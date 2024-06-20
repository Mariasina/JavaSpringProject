package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.services.AuthService;

@SpringBootTest
public class AuthTest {
    @Autowired
    AuthService authService;

    @Test
    void userAuthTest() {
        assertNotNull(authService.login("mari", "12345a"));
    }
}
