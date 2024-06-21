package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.services.AuthService;

@SpringBootTest
public class AuthServiceTests {
    
    @Autowired
	AuthService authService;


	@Test
	void authServiceTests() {
		assertEquals(authService.login("yas1234", "Haha@123"), null);
		assertNotEquals(authService.login("yas1234", "123"), null);
	}
}
