package com.trevis.startup.example.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.repositories.HelloMessageRepository;
import com.trevis.startup.example.services.HelloService;

public class DatabaseHelloService implements HelloService {
    @Autowired
    HelloMessageRepository repo;

    @Override
    public String getHello() {
        var hellos = repo.findAll();
        if (hellos.size() == 0)
            return "Goodbye!";
        
        var firstHello = hellos.get(0);
        return firstHello.getMessage();
    }
}