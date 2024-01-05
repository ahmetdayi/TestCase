package com.bobu.testcase.request;

import com.bobu.testcase.validation.PasswordMatching;
import com.bobu.testcase.validation.StrongPassword;
import jakarta.validation.constraints.NotBlank;

@PasswordMatching(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "Password and Confirm Password must be matched!"
)
public record UpdateChildRequest(
        @NotBlank String id,
        @StrongPassword
        String password,
        String confirmPassword,
        String name,
        String surname
) {
}
