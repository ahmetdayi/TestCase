package com.bobu.testcase.service;

import com.bobu.testcase.exception.AlreadyExistException;
import com.bobu.testcase.exception.Constant;
import com.bobu.testcase.exception.NotFoundException;
import com.bobu.testcase.model.SubscribeType;
import com.bobu.testcase.repository.SubscribeTypeRepository;
import com.bobu.testcase.request.CreateSubscribeTypeRequest;
import com.bobu.testcase.request.UpdateSubscribeTypeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscribeTypeService {

    private final SubscribeTypeRepository subscribeTypeRepository;

    public void create(CreateSubscribeTypeRequest request){
        if (subscribeTypeRepository.findByNameIgnoreCase(request.name()).isPresent()){
            throw new AlreadyExistException(Constant.ALREADY_EXIST);
        }
        SubscribeType subscribeType = new SubscribeType(request.name(), request.description(), request.price());
        subscribeTypeRepository.save(subscribeType);
    }
    public void update(UpdateSubscribeTypeRequest request){
        SubscribeType subscribeType = findById(request.id());

        subscribeType.setDescription(request.description().trim().isEmpty() ? subscribeType.getDescription() : request.description());
        subscribeType.setPrice(request.price() == null ? subscribeType.getPrice(): request.price());

        subscribeTypeRepository.save(subscribeType);
    }
    public void delete(String id){
        subscribeTypeRepository.delete(findById(id));
    }

    protected SubscribeType findById(String id){
        return subscribeTypeRepository.findById(id).orElseThrow(() -> new NotFoundException(Constant.NOT_FOUND));
    }
}
