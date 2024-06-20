package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.services.PasswordService;
import com.trevis.startup.example.services.ServiceService;

@SpringBootTest
public class PasswordTest {
    @Autowired
    PasswordService passwordService;

    @Test
    void CryptographyTest() {
        var passwordEncrypted = passwordService.applyCryptography("12345a");
        assertNotNull(passwordEncrypted);
        passwordService.verifyCryptography("12345a", passwordEncrypted);
    }

   
}
