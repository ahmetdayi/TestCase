package com.bobu.testcase.service;

import com.bobu.testcase.converter.LoginConverter;
import com.bobu.testcase.exception.Constant;
import com.bobu.testcase.exception.NotFoundException;
import com.bobu.testcase.model.SecurityUser;
import com.bobu.testcase.model.User;
import com.bobu.testcase.repository.UserRepository;
import com.bobu.testcase.request.LoginRequest;
import com.bobu.testcase.response.LoginResponse;
import com.bobu.testcase.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;



    protected User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(Constant.NOT_FOUND));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByEmail(username);
        return new SecurityUser(user);
    }
}
