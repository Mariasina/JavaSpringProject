package com.trevis.startup.example.services;

public interface JWTService {
    public String createJWT(Long id, Integer role);
    public void verifyJWT(String jwtToken);
}
