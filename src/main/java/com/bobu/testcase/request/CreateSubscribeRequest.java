package com.bobu.testcase.request;

import jakarta.validation.constraints.NotBlank;

public record CreateSubscribeRequest(
        @NotBlank String subscribeTypeId,
        @NotBlank String parentId
) {
}
