package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.model.User;
import com.trevis.startup.example.services.ServiceService;

@SpringBootTest
public class ServiceTest {
    @Autowired
    ServiceService serviceService;

    @Test
    void serviceTest() {
        serviceService.create(1l, "sites", "bla bla bla", false, new User());
        assertNotNull(serviceService.get("si", 1, 10));
    }

    @Test
    void serviceTestFalse() {
        serviceService.create(1l, "sites", "bla bla bla", false, new User());
        assertNull(serviceService.get("ba", 1, 10));
    }
}
