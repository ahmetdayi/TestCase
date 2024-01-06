package com.bobu.testcase.service;

import com.bobu.testcase.converter.ChildConverter;
import com.bobu.testcase.exception.AlreadyExistException;
import com.bobu.testcase.exception.Constant;
import com.bobu.testcase.exception.NotFoundException;
import com.bobu.testcase.model.Child;
import com.bobu.testcase.model.Parent;
import com.bobu.testcase.model.Role;
import com.bobu.testcase.repository.ChildRepository;
import com.bobu.testcase.request.CreateChildRequest;
import com.bobu.testcase.request.FindChildByParentsRequest;
import com.bobu.testcase.request.UpdateChildRequest;
import com.bobu.testcase.request.UpdateChild_ParentList_Request;
import com.bobu.testcase.response.ChildResponse;
import com.bobu.testcase.response.FindAllChildResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildService {
    private final ChildRepository childRepository;

    private final ParentService parentService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ChildConverter childConverter;

    public void create(CreateChildRequest request) {
        Child child;
        if (childRepository.findByEmail(request.email()).isPresent()){
            throw new AlreadyExistException(Constant.ALREADY_EXIST +" " + request.email());
        }

        if (!parentService.findByInviteCode(request.inviteCodeList()).isEmpty()) {
            List<Parent> parentList = parentService.findByInviteCode(request.inviteCodeList());
            child = new Child(
                    request.email(),
                    bCryptPasswordEncoder.encode(request.password()),
                    bCryptPasswordEncoder.encode(request.confirmPassword()),
                    request.name(),
                    request.surname(),
                    Role.CHILD, parentList);
        }else{
            child = new Child(
                    request.email(),
                    bCryptPasswordEncoder.encode(request.password()),
                    bCryptPasswordEncoder.encode(request.confirmPassword()),
                    request.name(),
                    request.surname(),
                    Role.CHILD);
        }

        childRepository.save(child);
    }

    public void update(UpdateChildRequest request){
        Child child = findById(request.id());
        child.setName(request.name().trim().isEmpty() ? child.getName() : request.name());
        child.setSurname(request.surname().trim().isEmpty() ? child.getSurname() : request.surname());
        childRepository.save(child);

    }

    public void updateParentList(UpdateChild_ParentList_Request request){
        Child child = findById(request.id());
        List<Boolean> list = child.getParentList().stream().map(parent -> request.parentList().stream().anyMatch(s -> parent.getInviteCode().equals(s))).toList();
        boolean result = list.contains(true);
        if (!result){
            List<Parent> parentList = parentService.findByInviteCode(request.parentList());

            child.getParentList().addAll(parentList);
            childRepository.save(child);
        }


    }
    public List<FindAllChildResponse> findAll(){
        return childConverter.getAllConvert(childRepository.findAll());

    }
    public List<ChildResponse> findByParentList_IdIn(FindChildByParentsRequest request){
        return childConverter.getConvert(childRepository.findByParentList_IdIn(request.parentIdList()));
    }
    public FindAllChildResponse getById(String id){
        return childConverter.getAllConvert(findById(id));
    }
    private Child findById(String id){
        return childRepository.findById(id).orElseThrow(() -> new NotFoundException(Constant.NOT_FOUND));
    }
}
