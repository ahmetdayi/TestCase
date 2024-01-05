package com.bobu.testcase.request;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record UpdateSubscribeTypeRequest(
        @NotBlank String id,
        String description,
        BigDecimal price
) {
}
