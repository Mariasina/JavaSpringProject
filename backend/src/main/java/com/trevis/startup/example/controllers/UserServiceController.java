package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.dto.PasswordPayLoad;
import com.trevis.startup.example.services.PasswordService;
// import com.trevis.startup.example.dto.Login;
import com.trevis.startup.example.services.UserService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserServiceController {
    
    @Autowired
    UserService validator;

    @Autowired
    PasswordService passValidator;

    // @PostMapping("/auth")
    // public Login TryLogin(@RequestBody Login login) {
    //     return 
    // }

    // @PostMapping("/user")
    // public String postMethodName(@RequestParam String login, @RequestParam String department, @RequestParam String role) {
        
    //     return "a";
    // }

    @PatchMapping("/user/{id}")
    public String patchData(@PathParam("id") Long id, @RequestBody PasswordPayLoad newPassword) {
        if (validator.updatePassword(id, newPassword.toString())) {
            return "Legal";
        }
        
        return "Erro";
    }

}
