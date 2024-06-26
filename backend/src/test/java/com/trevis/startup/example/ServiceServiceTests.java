package com.trevis.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.example.exceptions.NoSuchServiceException;
import com.trevis.startup.example.services.ServiceService;

@SpringBootTest
class ServiceServiceTests {
    
    @Autowired
    ServiceService service;

    @Test
    void serviceServiceTest() throws NoSuchServiceException{
        try {
            assertEquals(service.get(null, 1, 2), 2);
        } catch (NoSuchServiceException e) {
            System.out.println(e);
        }
    }
}
