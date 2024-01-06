package com.bobu.testcase.response;

import com.bobu.testcase.model.Role;

public record LoginResponse(
       String userId,

       String jwtToken,
       Role role
) {
}
