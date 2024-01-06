package com.bobu.testcase.converter;

import com.bobu.testcase.model.Subscribe;
import com.bobu.testcase.response.SubscribeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscribeConverter {
    private final SubscribeTypeConverter subscribeTypeConverter;

    public SubscribeResponse convert(Subscribe from){
        return new SubscribeResponse(from.getId(), subscribeTypeConverter.convert(from.getSubscribeType()));
    }
}
