package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.trevis.startup.example.services.PasswordService;

@SpringBootTest
class PasswordTests {

	@Autowired
	PasswordService passwordService;

	@Test
	void passwordRulesTest() {
		assertEquals(passwordService.verifyRules(null), 1);
		assertEquals(passwordService.verifyRules("joao"), 2);
		assertEquals(passwordService.verifyRules("Joao"), 3);
		assertEquals(passwordService.verifyRules("Joao13"), 4);
		assertEquals(passwordService.verifyRules("Joao@123"), 5);
	}

	@Test
	void cryptographyTestTrue() {
		String cryptography = passwordService.applyCryptography("123");
		assertNotNull(cryptography);
		assertTrue(passwordService.verifyCryptography("123", cryptography)); // Nesta linha estamos testando o método veryfy e apply ao mesmo tempo
	}

	@Test
	void cryptographyTestFalse() {
		String cryptography = passwordService.applyCryptography("123");
		assertNotNull(cryptography);
		assertFalse(passwordService.verifyCryptography("23", cryptography)); // Nesta linha estamos testando o método veryfy e apply ao mesmo tempo
	}
}