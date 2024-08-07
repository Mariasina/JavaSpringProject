package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.dto.Login;
import com.trevis.startup.example.services.AuthService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserLoginController {

    @Autowired
    AuthService auth;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/auth")
    public ResponseEntity<AuthToken> postMethodName(@RequestBody Login login) {
        return auth.login(login);
    }

}
