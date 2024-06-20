package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.services.UserService;

@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;

    @Test
    void userCreationTest() {
        userService.create(1l, "mari", "12345b", 0, new Department());
        var user = userService.get("mari");
        assertNotNull(user);
    }

    @Test
    void userUpdatePasswordTest() {
        userService.updatePassword(1l, "12345a");
        var user = userService.get("mari");
        assertEquals(user.getPassword(), "12345a");
    }
}