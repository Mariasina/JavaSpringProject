package com.trevis.startup.example.services;

import java.util.List;

public interface PasswordService {
    public String applyCryptography(String password);
    public Boolean verifyCryptography(String password, String encryptedPassword);
    public List<String> verifyRules(String password); //retorna lista de erros
}
