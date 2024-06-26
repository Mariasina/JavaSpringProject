package com.trevis.startup.example.controllers;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.dto.payload.LoginPayload;
import com.trevis.startup.example.dto.response.MessageResponse;
import com.trevis.startup.example.exceptions.BadHashConfigurationException;
import com.trevis.startup.example.exceptions.NoSuchEntityException;
import com.trevis.startup.example.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/api/auth")
    public ResponseEntity<MessageResponse> login(@RequestBody LoginPayload payload) {
        AuthToken token;

        try {
            token = authService.login(payload.login(), payload.password());
        } catch (NoSuchEntityException ex) {
            return ResponseEntity.notFound().build();
        } catch (NoSuchAlgorithmException ex) {
            return ResponseEntity.internalServerError().body(
                new MessageResponse("Bad authentication configuration on server.")
            );
        } catch (BadHashConfigurationException ex) {
            return ResponseEntity.internalServerError().body(
                new MessageResponse("Bad hashing configuration on the server.")
            );
        }

        if (token == null) {
            return ResponseEntity.status(403).body(new MessageResponse(
                "Passwords do not match."
            ));
        }

        return ResponseEntity.ok().body(new MessageResponse(token.token()));
    }
}
