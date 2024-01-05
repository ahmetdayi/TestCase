package com.bobu.testcase.request;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UpdateChild_ParentList_Request(
        @NotBlank String id,
        List<String> parentList
) {
}
