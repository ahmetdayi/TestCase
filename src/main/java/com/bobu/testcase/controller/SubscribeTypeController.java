package com.bobu.testcase.controller;

import com.bobu.testcase.request.CreateSubscribeTypeRequest;
import com.bobu.testcase.request.UpdateSubscribeTypeRequest;
import com.bobu.testcase.response.SubscribeTypeResponse;
import com.bobu.testcase.service.SubscribeTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribeType")
@RequiredArgsConstructor
public class SubscribeTypeController {
    private final SubscribeTypeService subscribeTypeService;

    @PostMapping("/admin/create")
    public ResponseEntity<Void> create(@Valid @RequestBody CreateSubscribeTypeRequest request){
        subscribeTypeService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<Void> update(@Valid @RequestBody UpdateSubscribeTypeRequest request){
        subscribeTypeService.update(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        subscribeTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<SubscribeTypeResponse>> findAll(){
        return new ResponseEntity<>(subscribeTypeService.findAll(),HttpStatus.OK);
    }
}
