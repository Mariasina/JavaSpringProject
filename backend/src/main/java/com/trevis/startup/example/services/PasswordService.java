package com.trevis.startup.example.services;

public interface PasswordService {
    
    public String applyCryptography(String password); 
    public Boolean verifyCryptography(String password, String encryptedPassword);
    public Boolean verifyRules(String password);
}
