package com.trevis.startup.example.services;

import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.dto.Login;

public interface AuthService {
    
    // ..authtoken eh um dto..
    public AuthToken login(Login loginUser);
}
