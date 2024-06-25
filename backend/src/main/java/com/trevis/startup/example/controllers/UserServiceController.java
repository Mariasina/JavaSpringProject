package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.trevis.startup.example.dto.PasswordPayLoad;
import com.trevis.startup.example.dto.UserCreate;
import com.trevis.startup.example.services.AuthJWTService;
import com.trevis.startup.example.services.UserService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
public class UserServiceController {
    
    @Autowired
    UserService validator;

    @Autowired
    AuthJWTService jwtService;

    @PostMapping("/user")
    public String postMethodName(@RequestBody UserCreate user, @RequestHeader String token) {

        // Integer role = jwtService.verifyJWT(token); 

        // if(role == 0)
            validator.create(user);
        // else
        // throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You don't have access to this feature.");

        return "Usuário criado";
    }

    @PatchMapping("/user/{id}")
    public String patchData(@PathVariable Long id, @RequestBody PasswordPayLoad newPassword) {
        if (validator.updatePassword(id, newPassword.newPassword())) {
            return "Senha atualizada";
        }
        
        return "Erro";
    }

}
