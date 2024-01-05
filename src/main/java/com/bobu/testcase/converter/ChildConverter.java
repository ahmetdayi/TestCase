package com.bobu.testcase.converter;

import com.bobu.testcase.model.Child;
import com.bobu.testcase.response.FindAllChildResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChildConverter {
    private final ParentConverter parentConverter;

    public Page<FindAllChildResponse> getAllConvert(Page<Child> fromList) {
        return fromList.map(from -> new FindAllChildResponse(
                from.getId(),
                from.getEmail(),
                from.getName(),
                from.getSurname(),
                parentConverter.convertGet(from.getParentList())));
    }
}
