package com.trevis.startup.example;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trevis.startup.example.impl.DatabaseHelloService;
import com.trevis.startup.example.impl.MockHelloService;
import com.trevis.startup.example.services.HelloService;

@Configuration
public class DependenciesConfiguration {

    @Bean
    public HelloService helloService() {
        Random rand = new Random();
        if (rand.nextInt(2) == 0)
            return new DatabaseHelloService();
        return new MockHelloService();
    }

}