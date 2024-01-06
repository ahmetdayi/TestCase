package com.bobu.testcase.converter;

import com.bobu.testcase.model.Child;
import com.bobu.testcase.response.ChildResponse;
import com.bobu.testcase.response.FindAllChildResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChildConverter {
    private final ParentConverter parentConverter;

    public List<FindAllChildResponse> getAllConvert(List<Child> fromList) {
        return fromList.stream().map(from -> new FindAllChildResponse(
                from.getId(),
                from.getEmail(),
                from.getName(),
                from.getSurname(),
                parentConverter.convertGet(from.getParentList()))).toList();
    }
    public FindAllChildResponse getAllConvert(Child from) {
        return  new FindAllChildResponse(
                from.getId(),
                from.getEmail(),
                from.getName(),
                from.getSurname(),
                parentConverter.convertGet(from.getParentList()));
    }
    public List<ChildResponse> getConvert(List<Child> fromList) {
        return fromList.stream().map(from -> new ChildResponse(
                from.getId(),
                from.getEmail(),
                from.getName(),
                from.getSurname()
               )).toList();
    }
}
