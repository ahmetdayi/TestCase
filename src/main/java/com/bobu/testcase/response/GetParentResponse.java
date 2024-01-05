package com.bobu.testcase.response;

public record GetParentResponse(
        String id,
        String email,
        String name,
        String surname,
        String inviteCode
) {
}
