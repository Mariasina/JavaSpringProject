package com.trevis.startup.example.services;

import org.springframework.http.ResponseEntity;

import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.dto.Login;

public interface AuthService {
    public ResponseEntity<AuthToken> login(Login login);
} 
