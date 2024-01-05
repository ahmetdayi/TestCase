package com.bobu.testcase.request;

import com.bobu.testcase.validation.PasswordMatching;
import com.bobu.testcase.validation.StrongPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@PasswordMatching(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "Password and Confirm Password must be matched!"
)
public record CreateChildRequest(
        @NotBlank
        @Size(max = 50)
        @Email
        String email,
        @StrongPassword
        @NotBlank String password,
        @NotBlank String confirmPassword,
        @NotBlank String name,
        @NotBlank String surname,
        List<String> inviteCodeList
) {
}
