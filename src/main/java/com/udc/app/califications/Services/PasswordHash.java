package com.udc.app.califications.Services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHash {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String hashPassword(String plainPass){
        return encoder.encode(plainPass);
    }

    public Boolean verifyPassword(String plainPass, String hashPass){
        return encoder.matches(plainPass,hashPass);
    }
}
