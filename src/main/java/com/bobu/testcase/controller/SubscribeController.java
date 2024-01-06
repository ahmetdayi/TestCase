package com.bobu.testcase.controller;

import com.bobu.testcase.request.CreateSubscribeRequest;
import com.bobu.testcase.response.SubscribeResponse;
import com.bobu.testcase.service.SubscribeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribe")
@RequiredArgsConstructor
public class SubscribeController {
    private final SubscribeService subscribeService;

    @PostMapping("/parent/create")
    public ResponseEntity<Void> create(@Valid @RequestBody CreateSubscribeRequest request){
        subscribeService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/parent/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        subscribeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<SubscribeResponse> findByUserId(@PathVariable String userId){
        return new ResponseEntity<>(subscribeService.findByUserId(userId),HttpStatus.OK);
    }
}
