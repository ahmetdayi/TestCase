package com.bobu.testcase.converter;

import com.bobu.testcase.model.SubscribeType;
import com.bobu.testcase.response.SubscribeTypeResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubscribeTypeConverter {

    public SubscribeTypeResponse convert(SubscribeType from){
        return new SubscribeTypeResponse(from.getId(), from.getName(), from.getDescription(),from.getPrice());
    }
    public List<SubscribeTypeResponse> convert(List<SubscribeType> fromList){
        return fromList
                .stream()
                .map
                        (from -> new SubscribeTypeResponse(
                                from.getId(), from.getName(), from.getDescription(),from.getPrice()))
                .toList();
    }
}
