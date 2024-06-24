package com.trevis.startup.example.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.model.UserData;
import com.trevis.startup.example.services.AuthService;
import com.trevis.startup.example.services.PasswordService;
import com.trevis.startup.example.services.UserService;

public class DefaultAuthService implements AuthService {
    @Autowired
    JWTService jwt;

    @Autowired
    UserService userService;

    @Autowired
    PasswordService passService;

    @SuppressWarnings("unused")
    @Override
    public AuthToken login(String username, String password) {
        UserData user = userService.get(username);
        Long userId = user.getId();
        Integer userRole = user.getRole();

        if(user == null){
            return new AuthToken("User not found", null);
        }
        else if(!passService.verifyCryptography(password, user.getPassword())){
            return new AuthToken("Incorect password", null);
        }
        else{
            String token = jwt.createJWT(userId, userRole);
            return new AuthToken("Login was succesful", token);
        }    
    }

    
}