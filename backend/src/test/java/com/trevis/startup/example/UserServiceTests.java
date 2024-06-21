package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.model.DepartmentData;
import com.trevis.startup.example.services.UserService;

@SpringBootTest
public class UserServiceTests {

    @Autowired
	UserService userService;
    
    @Test
	void userGet() {
		assertEquals(userService.get("pedrin"), null);
	}

    @Test
    void userCreate() {
        assertEquals(userService.create(1l, "jessiquinha123", 0, new DepartmentData()), true);
		assertEquals(userService.create(1l, "jessiquinha123", 0, new DepartmentData()), false);
    }

    @Test
    void userUpdatePassword() {
        assertEquals(userService.updatePassword(1l, "Haha@12356!"), true);
		assertEquals(userService.updatePassword(53426523l, "Haha@12356!"), false);
		assertEquals(userService.updatePassword(1l, "22"), false);
    }
}
