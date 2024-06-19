package com.trevis.startup.example.services;

public interface PasswordService {
    void applyCryptography(String password);
    void verifyCryptography(String password, String encryptedPassword);
    void verifyRules(String password);
}