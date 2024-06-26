package com.trevis.startup.example.impl.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.exceptions.BadHashConfigurationException;
import com.trevis.startup.example.exceptions.ClaimsConversionException;
import com.trevis.startup.example.exceptions.InvalidAuthAttempt;
import com.trevis.startup.example.exceptions.NoSuchEntityException;
import com.trevis.startup.example.model.User;
import com.trevis.startup.example.repositories.UserJPARepository;
import com.trevis.startup.example.services.AuthService;
import com.trevis.startup.example.services.PasswordService;

public class JwtAuthService implements AuthService {
    @Autowired
    UserJPARepository userRepo;

    @Autowired
    PasswordService passwordService;

    static private KeyPair keyPair;

    static private void generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);

        keyPair = generator.generateKeyPair();
    }

    public AuthToken login(String username, String password)
            throws
                NoSuchAlgorithmException,
                ClaimsConversionException,
                NoSuchEntityException,
                BadHashConfigurationException {

        if (keyPair == null) {
            generateRSAKeyPair();
        }

        List<User> matchingUsers = userRepo.findByUsernameContaining(username);
        if (matchingUsers.size() == 0) {
            throw new NoSuchEntityException(
                "No user matches the given username."
            );
        }

        User user = matchingUsers.get(0);
        if (!passwordService.verifyCryptography(password, user.getPassword())) {
            return null;
        }

        var publicKey = (RSAPublicKey) keyPair.getPublic();
        var privateKey = (RSAPrivateKey) keyPair.getPrivate();

        String token;
        try {
            Algorithm algorithm = Algorithm.RSA512(publicKey, privateKey);
            token = JWT.create()
                .withIssuer("Andrezinho")
                .withClaim("userId", user.getId().toString())
                .withExpiresAt(Instant.now().plusSeconds(28800))
                .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new ClaimsConversionException(
                "Claims could not be converted."
            );
        }

        return new AuthToken("Login was successful", token);
    }

    public DecodedJWT decode(String token)
        throws
            NoSuchAlgorithmException,
            InvalidAuthAttempt {

        if (keyPair == null) {
            generateRSAKeyPair();
        }

        var publicKey = (RSAPublicKey) keyPair.getPublic();
        var privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Algorithm algorithm = Algorithm.RSA512(publicKey, privateKey);
        Verification verification = JWT.require(algorithm)
            .withIssuer("Andrezinho");

        try {
            JWTVerifier verifier = verification.build();
            return verifier.verify(token);
        } catch (JWTVerificationException ex) {
            throw new InvalidAuthAttempt("Invalid token");
        }
    }
}
