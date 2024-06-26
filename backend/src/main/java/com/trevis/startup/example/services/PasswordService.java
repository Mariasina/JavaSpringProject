package com.trevis.startup.example.services;

import com.trevis.startup.example.exceptions.BadHashConfigurationException;

public interface PasswordService {
    String applyCryptography(String password) throws BadHashConfigurationException ;
    Boolean verifyCryptography(String password, String encryptedPassword) throws BadHashConfigurationException;
    int verifyRules(String password);
}