package com.trevis.startup.example;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.services.UserService;

@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;

    @Test
    void userCreationTest() {
        
    }
}