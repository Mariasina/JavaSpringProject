package com.trevis.startup.example;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.trevis.startup.example.impl.*;
import com.trevis.startup.example.services.*;

@Configuration
public class DependenciesConfiguration {

    @Bean
    public HelloService helloService() {
        Random rand = new Random();
        if (rand.nextInt(2) == 0)
            return new DatabaseHelloService();
        return new MockHelloService();
    }

    @Bean
    @Scope
    public UserService userService() {
        return new MockUserService();
    }

    @Bean
    @Scope
    public DepartmentService departmentService() {
        return new MockDepartmentService();
    }

    @Bean
    @Scope
    public ServiceService serviceService() {
        return new MockServiceService();
    }

}