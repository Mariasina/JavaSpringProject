package com.trevis.startup.example.services;

import com.trevis.startup.example.dto.AuthToken;

public interface AuthService {
    
    // ..authtoken eh um dto..
    public AuthToken login(String username, String password);
}
