package com.trevis.startup.example;

import java.security.NoSuchAlgorithmException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trevis.startup.example.impl.*;
import com.trevis.startup.example.services.*;

@Configuration
public class DependenciesConfiguration {

    // mocks
    // @Bean
    // public UserService userService() {
    //     return new MockUserService();
    // }

    // @Bean
    // public DepartmentService departmentService() {
    //     return new MockDepartmentService();
    // }

    // @Bean
    // public ServiceService serviceService() {
    //     return new MockServiceService();
    // }

    // implementacao de fato
    @Bean
    public UserService userService() {
        return new DatabaseUserService();
    }

    @Bean
    public DepartmentService departmentService() {
        return new DatabaseDepartmentService();
    }

    @Bean
    public ServiceService serviceService() {
        return new DatabaseServiceService();
    }

    @Bean
    public PasswordService passwordService() {
        return new DefaultPasswordService();
    }

    @Bean
    public AuthService authService() {
        return new DefaultAuthService();
    }

    @Bean
    public JWTService jwtService() {
        return new DefaultJWTService();
    }
}