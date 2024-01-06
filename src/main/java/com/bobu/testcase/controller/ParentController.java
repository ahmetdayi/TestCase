package com.bobu.testcase.controller;

import com.bobu.testcase.request.CreateParentRequest;
import com.bobu.testcase.service.ParentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@Valid @RequestBody CreateParentRequest request){
        parentService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
