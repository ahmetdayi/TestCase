package com.bobu.testcase.response;

public record SubscribeResponse(
        String id,
        SubscribeTypeResponse subscribeType
) {
}
