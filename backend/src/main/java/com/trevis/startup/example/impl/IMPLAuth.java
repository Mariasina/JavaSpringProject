package com.trevis.startup.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.trevis.startup.example.dto.Login;

import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.repositories.UserJPARepository;
import com.trevis.startup.example.services.AuthService;
import com.trevis.startup.example.services.PasswordService;

public class IMPLAuth implements AuthService{

    @Autowired
    JWTGenerator jwt;

    @Autowired
    UserJPARepository repoUser;

    @Autowired
    PasswordService pass;

    @Override
    public ResponseEntity<AuthToken> login(Login login) {
        var users = repoUser.findByLogin(login.login());
        if (users.size() == 0)
            return ResponseEntity
                .status(401)
                .body(new AuthToken("Login desconhecido", null));
        
        var user = users.get(0);
        
        if (!pass.verifyCryptography(login.password(), user.getPassword())) {
            return ResponseEntity
                .status(401)
                .body(new AuthToken("Senha incorreta!", null));
        }
        
        var token = jwt.create(user);
        return ResponseEntity.ok(new AuthToken("Login realizado com sucesso!", token));
    }
    
}