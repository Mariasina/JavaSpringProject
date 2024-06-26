package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.services.DepartmentService;

@SpringBootTest
class DepartmentServiceTests {
    
    @Autowired
    DepartmentService service;

    @Test
    void departmentTest() {
        assertTrue(service.getAll().size() > 0);
    }

}
