package com.bobu.testcase.controller;

import com.bobu.testcase.request.CreateChildRequest;
import com.bobu.testcase.request.FindChildByParentsRequest;
import com.bobu.testcase.request.UpdateChildRequest;
import com.bobu.testcase.request.UpdateChild_ParentList_Request;
import com.bobu.testcase.response.ChildResponse;
import com.bobu.testcase.response.FindAllChildResponse;
import com.bobu.testcase.service.ChildService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Void> update(@Valid @RequestBody UpdateChildRequest request){
        childService.update(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/child/updateParentList")
    public ResponseEntity<Void> updateParentList(@Valid @RequestBody UpdateChild_ParentList_Request request){
        childService.updateParentList(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/child/findAll")
    public ResponseEntity<List<FindAllChildResponse>> findAll(){
        return new ResponseEntity<>(childService.findAll(),HttpStatus.CREATED);
    }
    @GetMapping("/child/findById/{id}")
    public ResponseEntity<FindAllChildResponse> findById(@PathVariable String id){
        return new ResponseEntity<>(childService.getById(id),HttpStatus.OK);
    }
    //invitecod guncellendiginde eger zaten o invite kodla iliskilendirilmisse iliskilendirilmesin
    @PostMapping("/findByParentList_IdIn")
    public ResponseEntity<List<ChildResponse>> findByParentList_IdIn(@RequestBody FindChildByParentsRequest request){
        return new ResponseEntity<>(childService.findByParentList_IdIn(request),HttpStatus.OK);
    }


}
