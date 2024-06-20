package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.services.PasswordService;

// @SpringBootTest
public class PasswordTest {
    @Autowired
    PasswordService passwordService;

    @Test
    void CryptographyTest() {
        var passwordEncrypted = passwordService.applyCryptography("12345a");
        assertNotNull(passwordEncrypted);
        assertTrue(passwordService.verifyCryptography("12345a", passwordEncrypted));
    }

    @Test
    void CryptographyFalseTest() {
        var passwordEncrypted = passwordService.applyCryptography("12345a");
        assertFalse(passwordService.verifyCryptography("12345a", passwordEncrypted));
    }

    @Test
    void VerifyRulesTest() {
        assertEquals(passwordService.verifyRules(null), 1);
        assertEquals(passwordService.verifyRules("marao"), 2);
        assertEquals(passwordService.verifyRules("joaoemaria"), 3);
        assertEquals(passwordService.verifyRules("JoaoeMaria"), 4);
        assertEquals(passwordService.verifyRules("123JoaoeMaria123"), 5);
    }
}