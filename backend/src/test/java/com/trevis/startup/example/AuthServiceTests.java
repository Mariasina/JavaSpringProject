package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.dto.AuthToken;
import com.trevis.startup.example.services.AuthService;

@SpringBootTest
class AuthServiceTests {

    @Autowired
    AuthService authservice;

    @Test
    void authServiceTest(){
        AuthToken token = assertDoesNotThrow(() -> authservice.login("Joao", "JoaoEmoo8"));
        AuthToken nullToken = assertDoesNotThrow(() -> authservice.login("Joao", "null"));

        assertNotEquals(token, null);
        assertEquals(nullToken, null);
    }
}
