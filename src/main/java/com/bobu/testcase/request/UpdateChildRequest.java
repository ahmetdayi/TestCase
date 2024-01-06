package com.bobu.testcase.request;

import jakarta.validation.constraints.NotBlank;


public record UpdateChildRequest(
        @NotBlank String id,

        String name,
        String surname
) {
}
