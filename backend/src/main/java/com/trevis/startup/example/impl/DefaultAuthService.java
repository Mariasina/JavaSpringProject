package com.trevis.startup.example.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.services.AuthService;

public class DefaultAuthService implements AuthService {
    @Override
    public AuthToken login(String username, String password) {
        String jwtToken = "ablublublé";

        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); // Cria o verificador

            // Verifica e decodifica o token
            DecodedJWT decodedJWT = verifier.verify(jwtToken);

            // Exibe as informações decodificadas do token
            System.out.println("Username: " + decodedJWT.getClaim("username").asString());
            System.out.println("Role: " + decodedJWT.getClaim("role").asString());
            System.out.println("Issued At: " + decodedJWT.getIssuedAt());

        } catch (JWTVerificationException exception) {
            // Exceção lançada se a verificação falhar
            System.out.println("Token inválido!");
        }

        return null;
    }
}