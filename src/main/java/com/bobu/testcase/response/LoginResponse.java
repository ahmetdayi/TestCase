package com.bobu.testcase.response;

public record LoginResponse(
       String userId,

       String jwtToken
) {
}
