package com.bobu.testcase.config;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class InviteKeyGenerator {
    public String generateRandomKey(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomKey = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            randomKey.append(characters.charAt(randomIndex));
        }

        return randomKey.toString();
    }
}
