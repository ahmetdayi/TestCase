package com.bobu.testcase.converter;

import com.bobu.testcase.model.Parent;
import com.bobu.testcase.response.GetParentResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParentConverter {

    public List<GetParentResponse> convertGet(List<Parent> fromList) {
        return fromList
                .stream()
                .map(
                        from -> new GetParentResponse(
                                from.getId(),
                                from.getEmail(),
                                from.getName(),
                                from.getSurname(),
                                from.getInviteCode()))
                .toList();
    }
}
