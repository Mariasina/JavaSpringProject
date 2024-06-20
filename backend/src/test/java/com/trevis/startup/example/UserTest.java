package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.services.AuthService;
import com.trevis.startup.example.services.UserService;

@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Test
    void userAndAuthTest() {
        //testing create user
        userService.create(1l, "mari", "12345b", 0, new Department());
        //testing get user
        var user = userService.get("mari");
        assertNotNull(user);

        //testing update password
        userService.updatePassword(1l, "12345a");
        assertEquals(user.getPassword(), "12345a");

        //testing user authentification
        assertNotNull(authService.login("mari", "12345a"));
    }
}