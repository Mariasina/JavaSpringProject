package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.services.HelloService;

@RestController
public class TestController {

    @Autowired
    HelloService helloService;

    @GetMapping("test")
    public String test() {
        return helloService.getHello();
    }   
}