package com.bobu.testcase.response;

import java.util.List;

public record FindAllChildResponse(
        String id,
        String email,
        String name,
        String surname,
        List<GetParentResponse> parentList
) {
}
