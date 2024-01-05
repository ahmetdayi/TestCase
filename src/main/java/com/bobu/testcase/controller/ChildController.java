package com.bobu.testcase.controller;

import com.bobu.testcase.request.CreateChildRequest;
import com.bobu.testcase.request.UpdateChildRequest;
import com.bobu.testcase.request.UpdateChild_ParentList_Request;
import com.bobu.testcase.response.FindAllChildResponse;
import com.bobu.testcase.service.ChildService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/child")
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;


    @PostMapping("/create")
    public ResponseEntity<Void> create(@Valid @RequestBody CreateChildRequest request){
       childService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Void> create(@Valid @RequestBody UpdateChildRequest request){
        childService.update(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/child/updateParentList")
    public ResponseEntity<Void> updateParentList(@Valid @RequestBody UpdateChild_ParentList_Request request){
        childService.updateParentList(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/child/findAll/{size}/{pageNumber}")
    public ResponseEntity<Page<FindAllChildResponse>> findAll(@PathVariable Integer size, @PathVariable Integer pageNumber){
        return new ResponseEntity<>(childService.findAll(size, pageNumber),HttpStatus.CREATED);
    }


}
