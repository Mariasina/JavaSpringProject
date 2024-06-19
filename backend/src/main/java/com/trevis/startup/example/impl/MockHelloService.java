package com.trevis.startup.example.impl;

import com.trevis.startup.example.services.HelloService;

public class MockHelloService implements HelloService {
    @Override
    public String getHello() {
        return "Hello Spring Boot!";
    }  
}