package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.services.PasswordService;

@SpringBootTest
public class PasswordServiceTests {
    
    @Autowired
	PasswordService passwordService;

    @Test
	void passwordVerifyRules() {
		assertEquals(passwordService.verifyRules("1243"), false);
		assertEquals(passwordService.verifyRules("Haha@123456!"), true);
	}
    
    @Test
    void passwordVerifyCryptography() {
        var pass = passwordService.applyCryptography("123");

        assertEquals(passwordService.verifyCryptography("123", pass), true);
        assertEquals(passwordService.verifyCryptography(pass, "jshfkhagfhakfdh"), false);
    }
}
