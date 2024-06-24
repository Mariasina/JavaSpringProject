package com.trevis.startup.example.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.trevis.startup.example.services.PasswordService;

public class DefaultPasswordService implements PasswordService {
    BCryptPasswordEncoder incryptionService = new BCryptPasswordEncoder();

    @Override
    public String applyCryptography(String password) {
        return incryptionService.encode(password);
    }

    @Override
    public Boolean verifyCryptography(String password, String encryptedPassword) {
        return incryptionService.matches(password, encryptedPassword);
    }

    @Override
    public Boolean verifyRules(String password) {
        Boolean hasUpper = false;
        Boolean hasLower = false;
        Boolean hasNumber = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i)))
                hasUpper = true;

            if (Character.isLowerCase(password.charAt(i)))
                hasLower = true;

            if (!Character.isDigit(password.charAt(i)))
                hasNumber = true;
        }

        if (hasUpper == false)
            return false;
        else if (hasLower == false)
            return false;
        else if (hasNumber == false)
            return false;
        else if(password.length() < 8)
            return false;
        else
            return true;
    }

}
