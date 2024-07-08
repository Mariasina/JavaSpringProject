package com.trevis.startup.example.impl;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.trevis.startup.example.dto.Payload;
import com.trevis.startup.example.model.UserModel;

public class JWTGenerator {
    @Autowired
    IMPLKeyPairManagement key;

    public String create(UserModel user) {
        var algorithm = Algorithm.RSA256(
            key.getKeyPublic(), 
            key.getKeyPrivate()
        );

        String token = JWT.create()
            .withIssuer("auth0")
            .withClaim("id", user.getId().toString())
            .withClaim("role", user.getRole().toString())
            .withExpiresAt(Date.from(Instant.now().plusSeconds(28800)))
            .sign(algorithm);

        return token;
    }

    public Payload verificate(String token) {
        DecodedJWT decodedJWT;

        try {
            Algorithm algorithm = Algorithm.RSA256(key.getKeyPublic(), key.getKeyPrivate());

            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
            
            decodedJWT = verifier.verify(token);
        
            Integer role = Integer.parseInt(decodedJWT.getClaim("role").asString());
            Integer id = Integer.parseInt(decodedJWT.getClaim("id").asString());

            return new Payload(id, role);

        } catch (Exception exception) {
            // exception.printStackTrace();
            return null;
        }
    }
}
