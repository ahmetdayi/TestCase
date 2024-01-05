package com.bobu.testcase.service;

import com.bobu.testcase.converter.LoginConverter;
import com.bobu.testcase.request.LoginRequest;
import com.bobu.testcase.response.LoginResponse;
import com.bobu.testcase.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final LoginConverter converter;
    private final UserService userService;



    public LoginResponse login(LoginRequest request){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
                (request.email(),
                        request.password());
        Authentication authenticate = authenticationManager.authenticate(token);
        System.out.println(authenticate.getName());
        String userId= userService.findByEmail(authenticate.getName()).getId();

        return converter.convert(jwtUtil.generateToken(authenticate),userId);
    }
}
