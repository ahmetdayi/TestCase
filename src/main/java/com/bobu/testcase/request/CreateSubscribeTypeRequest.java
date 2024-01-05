package com.bobu.testcase.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateSubscribeTypeRequest(
        @NotBlank String name,
        @NotBlank String description,
        @NotNull BigDecimal price
) {
}
