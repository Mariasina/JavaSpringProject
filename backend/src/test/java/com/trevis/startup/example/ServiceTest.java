package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.services.ServiceService;

@SpringBootTest
public class ServiceTest {
    @Autowired
    ServiceService serviceService;

    @Test
    void serviceGetTest() {
        assertNotNull(serviceService.get("ba", 1, 10));
    }
}
