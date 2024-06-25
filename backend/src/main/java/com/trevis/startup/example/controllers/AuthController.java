package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.services.PasswordService;

@RestController
public class AuthController {

    @Autowired
    PasswordService passValidator;

    // @PostMapping("/auth")
    // public Login TryLogin(@RequestBody Login login) {
    //     return 
    // }
}
