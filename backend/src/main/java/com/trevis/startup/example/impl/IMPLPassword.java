package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.trevis.startup.example.services.PasswordService;

public class IMPLPassword implements PasswordService {

    @Override
    public String applyCryptography(String password) {
        String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
        return pw_hash;
    }

    @Override
    public Boolean verifyCryptography(String password, String encryptedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, encryptedPassword);
    }

    @Override
    public List<String> verifyRules(String password) {
        List<String> rules = new ArrayList<>();

        if (!verifyLenght(password)) {
            rules.add("The password must have at least 8 character");
        }
        if (!verifyUpperCase(password)) {
            rules.add("The password must have uppercase letters");
        }
        if (!verifyLowerCase(password)) {
            rules.add("The password must have lowercase letters");
        }
        if (!verifyDigit(password)) {
            rules.add("The password must have numbers");
        }

        return rules;
    }

    public boolean verifyLenght(String password) {
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    public boolean verifyUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                return true;
            } 
        }
        return false;
    }

    public boolean verifyLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                return true;
            } 
        }
        return false;
    }

    public boolean verifyDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

}
