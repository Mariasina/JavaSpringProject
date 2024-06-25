package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.dto.Login;
import com.trevis.startup.example.services.AuthService;
import com.trevis.startup.example.services.PasswordService;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/auth")
    public AuthToken TryLogin(@RequestBody Login login) {
        var token = authService.login(login);
        return token;
    }
}
