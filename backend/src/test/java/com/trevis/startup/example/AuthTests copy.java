package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.services.AuthService;

@SpringBootTest
class AuthTests {

	@Autowired
	AuthService authService;

	@Test
	void authTestTrue() {
		assertNotEquals(authService.login("Mavi", "Joa0Lind@"), null);
		//Você precisa passar um valor real neste
	}
	
	@Test
	void authTestFalse() {
		assertEquals(authService.login("Mavi", "joao"), null);
		//E um valor falso neste
	}
}