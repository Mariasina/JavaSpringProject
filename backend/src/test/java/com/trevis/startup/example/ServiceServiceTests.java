package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.services.ServiceService;

@SpringBootTest
public class ServiceServiceTests {
    
    @Autowired
	ServiceService serviceService;

    @Test
	void serviceServiceTests() {
		assertEquals(serviceService.get("ac", 2, 10), null);
		assertEquals(serviceService.get("ac", 0, 10), null);
		assertNotNull(serviceService.get("", 2, 10));
	}
}
