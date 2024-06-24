package com.trevis.startup.example.impl;

import com.auth0.jwt.algorithms.Algorithm;
import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.services.AuthService;

public class DefaultAuthService implements AuthService {
    @Override
    public AuthToken login(String username, String password) {
        Algorithm algorithm = Algorithm.HMAC256("bungas");
    }
}