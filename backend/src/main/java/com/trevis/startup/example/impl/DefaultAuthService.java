package com.trevis.startup.example.impl;

import java.time.Instant;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class DefaultAuthService {

    // Dados fictícios do usuário
    String username = "john.doe";
    String role = "admin";
    
    // Criação do JWT
    String jwtToken = JWT.create()
        .withClaim("username", username)
        .withClaim("role", role)
        .withClaim("createdAt", Instant.now().toEpochMilli())
        .sign(Algorithm.HMAC256("secret")); // Assinatura com chave secreta (exemplo: "secret")

    public void print() {
        // Exibindo o token gerado
        System.out.println("JWT Token: " + jwtToken);
    }
}