package com.trevis.startup.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
    @Scope
    public UserService userService() {
        return new DatabaseUserService();
    }

    @Bean
    @Scope
    public DepartmentService departmentService() {
        return new DatabaseDepartmentService();
    }

    @Bean
    @Scope
    public ServiceService serviceService() {
        return new DatabaseServiceService();
    }

    @Bean
    @Scope
    public PasswordService passwordService() {
        return new DefaultPasswordService();
    }

    @Bean
    @Scope
    public AuthService authService() {
        return new DefaultAuthService();
    }

    @Bean
    @Scope
    public AuthJWTService authJwtService() {
        return new DefaultJWTService();
    }

    @Bean
    @Scope
    public AuthKeyService authKeyService() {
        return new DefaultKeyService();
    }
}