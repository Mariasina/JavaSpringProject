package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.model.User;
import com.trevis.startup.example.model.UserType;
import com.trevis.startup.example.services.UserService;


@SpringBootTest
class UserServiceTests {
    
    @Autowired
    UserService service;

    @Test
    void userCreateTest() {
        Department department = new Department();
        department.setName("Management");
        UserType usertype = new UserType();
        usertype.setType("Manager");
        User createUser = service.create("Don", department, usertype);

        assertNotNull(createUser.getId());
        assertEquals("Don", createUser.getUsername());
        assertEquals(department, createUser.getDepartment());
        assertEquals(usertype, createUser.getUsertype());
    }

    @Test
    void userUpdatePassTest() {
        Department department = new Department();
        department.setName("Management");
        UserType usertype = new UserType();
        usertype.setType("Manager");
        User createUser = service.create("Queila", department, usertype);

        assertDoesNotThrow(() -> service.updatePassword(createUser.getId(), "12345678"));

        assertEquals(createUser.getPassword(), "12345678");
    }

    @Test
    void UserGetTest(){
        Department department = new Department();
        department.setName("Management");
        UserType usertype = new UserType();
        usertype.setType("Manager");
        User createUser = service.create("Joao", department, usertype);

        User userInDatabase = assertDoesNotThrow(() -> service.get("Joao"));

        assertEquals(userInDatabase, createUser);
    }
}
