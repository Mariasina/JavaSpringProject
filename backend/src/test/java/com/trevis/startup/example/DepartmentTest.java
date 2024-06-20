package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.trevis.startup.example.services.DepartmentService;

@SpringBootTest
public class DepartmentTest {
    @Autowired
    DepartmentService departmentService;

    @Test
    void departmentGetAllTest() {
        //create department and verify that getAll doesn't return null
        departmentService.create(1l, "RH");
        assertNotNull(departmentService.getAll());
    }

    @Test
    void departmentGetAllFailedTest() {
        //calls getAll without creating any departments, excpecting null
        assertNull(departmentService.getAll());
    }
}