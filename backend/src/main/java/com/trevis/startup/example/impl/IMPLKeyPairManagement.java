package com.trevis.startup.example.impl;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class IMPLKeyPairManagement {
    private KeyPair keyPair;

    public IMPLKeyPairManagement() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048); 
            this.keyPair = kpg.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public RSAPublicKey getKeyPublic() {
        return (RSAPublicKey) this.keyPair.getPublic();
    }
    public RSAPrivateKey getKeyPrivate() {
        return (RSAPrivateKey) this.keyPair.getPrivate();
    }
}
