package com.trevis.startup.example.services;

public interface AuthJWTService {
    public String createJWT(Long id, Integer role);
    public void verifyJWT(String jwtToken);
}
