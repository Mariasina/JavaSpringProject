package com.trevis.startup.example.services;

import java.security.NoSuchAlgorithmException;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.exceptions.BadHashConfigurationException;
import com.trevis.startup.example.exceptions.ClaimsConversionException;
import com.trevis.startup.example.exceptions.InvalidAuthAttempt;
import com.trevis.startup.example.exceptions.NoSuchEntityException;

public interface AuthService {
    public AuthToken login(String username, String password)
        throws
            NoSuchAlgorithmException,
            ClaimsConversionException,
            NoSuchEntityException,
            BadHashConfigurationException;
    
    public DecodedJWT decode(String token)
        throws
            NoSuchAlgorithmException,
            InvalidAuthAttempt;
}
