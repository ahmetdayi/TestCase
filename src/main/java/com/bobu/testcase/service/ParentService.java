package com.bobu.testcase.service;

import com.bobu.testcase.config.InviteKeyGenerator;
import com.bobu.testcase.exception.AlreadyExistException;
import com.bobu.testcase.exception.Constant;
import com.bobu.testcase.exception.NotFoundException;
import com.bobu.testcase.model.Parent;
import com.bobu.testcase.model.Role;
import com.bobu.testcase.repository.ParentRepository;
import com.bobu.testcase.request.CreateParentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final InviteKeyGenerator inviteKeyGenerator;

    public void create(CreateParentRequest request){
        if (parentRepository.findByEmail(request.email()).isPresent()){
            throw new AlreadyExistException(Constant.ALREADY_EXIST +" " + request.email());
        }
        Parent parent = new Parent(
                request.email(),
                bCryptPasswordEncoder.encode(request.password()),
                bCryptPasswordEncoder.encode(request.confirmPassword()),
                request.name(),
                request.surname(),
                Role.PARENT,
                inviteKeyGenerator.generateRandomKey(10)
                );
        parentRepository.save(parent);
    }

    protected List<Parent> findByInviteCode(List<String> inviteCodeList){
        return parentRepository
                .findByInviteCodeIn(inviteCodeList);
    }

    protected Parent findById(String id){
        return parentRepository.findById(id).orElseThrow(() -> new NotFoundException(Constant.NOT_FOUND));
    }


}
