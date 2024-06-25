package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.dto.PasswordPayLoad;
import com.trevis.startup.example.dto.UserCreate;
import com.trevis.startup.example.services.UserService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserServiceController {
    
    @Autowired
    UserService validator;

    @PostMapping("/user")
    public String postMethodName(@RequestBody UserCreate user) {
        validator.create(user);

        return "Usuário criado";
    }

    @PatchMapping("/user/{id}")
    public String patchData(@PathParam("id") Long id, @RequestBody PasswordPayLoad newPassword) {
        if (validator.updatePassword(id, newPassword.toString())) {
            return "Senha atualizada";
        }
        
        return "Erro";
    }

}
