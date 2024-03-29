package com.bobu.testcase.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateSubscribeTypeRequest(
        @NotBlank String name,
        @NotBlank String description,
        @Min(0)
        @NotNull BigDecimal price
) {
}
