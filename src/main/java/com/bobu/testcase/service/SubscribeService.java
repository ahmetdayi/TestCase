package com.bobu.testcase.service;

import com.bobu.testcase.exception.Constant;
import com.bobu.testcase.exception.NotFoundException;
import com.bobu.testcase.model.Parent;
import com.bobu.testcase.model.Subscribe;
import com.bobu.testcase.model.SubscribeType;
import com.bobu.testcase.repository.SubscribeRepository;
import com.bobu.testcase.request.CreateSubscribeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;
    private final SubscribeTypeService subscribeTypeService;
    private final ParentService parentService;

    public void create(CreateSubscribeRequest request){
        Parent parent = parentService.findById(request.parentId());
        SubscribeType subscribeType = subscribeTypeService.findById(request.subscribeTypeId());
        Subscribe subscribe = new Subscribe(subscribeType,parent);
        subscribeRepository.save(subscribe);

        // Normalde buraya subs oldugu tariuhi alip substypina gore o trihte iliskiyi
        // otomatik silmek gerekiyor ancak simdilik o istenmemis o yuzden es geciyorum
    }

    public void delete(String id){
        subscribeRepository.delete(findById(id));
    }

    private Subscribe findById(String id) {
        return subscribeRepository.findById(id).orElseThrow(() -> new NotFoundException(Constant.NOT_FOUND));
    }
}
