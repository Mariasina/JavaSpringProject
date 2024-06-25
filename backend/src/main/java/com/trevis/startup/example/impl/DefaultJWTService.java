package com.trevis.startup.example.impl;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.trevis.startup.example.services.AuthJWTService;
import com.trevis.startup.example.services.AuthKeyService;

import jakarta.annotation.PostConstruct;

public class DefaultJWTService implements AuthJWTService{
    @Autowired
    AuthKeyService keyService;
    
    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;
    private Algorithm algorithm;

    public DefaultJWTService(){
    }

    @PostConstruct
    void init()
    {
        privateKey = keyService.getPrivateKey();
        publicKey = keyService.getPublicKey();

        algorithm = Algorithm.RSA256(publicKey, privateKey);

    }

    @Override
    public String createJWT(Long id, Integer role) {
        String jwtToken = JWT.create()
                .withIssuer("Auth Service")
                .withClaim("id", id)
                .withClaim("role", role)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 5000L))
                .sign(algorithm);
        return jwtToken;
    }

    @Override
    public void verifyJWT(String jwtToken) {
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); 

            // Verifica e decodifica o token
            DecodedJWT decodedJWT = verifier.verify(jwtToken);

            // Exibe as informações decodificadas do token
            System.out.println("Id: " + decodedJWT.getClaim("id").asString());
            System.out.println("Role: " + decodedJWT.getClaim("role").asString());
            System.out.println("Issued At: " + decodedJWT.getIssuedAt());

        } catch (JWTVerificationException exception) {
            // Exceção lançada se a verificação falhar
            System.out.println("Token inválido!");
        }

    }

}
