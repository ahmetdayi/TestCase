package com.bobu.testcase.converter;

import com.bobu.testcase.model.Role;
import com.bobu.testcase.response.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class LoginConverter {

    public LoginResponse convert(String token, String userid, Role role){
        return new LoginResponse(userid,token,role);
    }
}
