package com.trevis.startup.example.services;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public interface AuthKeyService {
    RSAPrivateKey getPrivateKey();
    RSAPublicKey getPublicKey();
}
