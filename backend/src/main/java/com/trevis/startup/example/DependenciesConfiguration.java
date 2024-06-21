package com.trevis.startup.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trevis.startup.example.impl.MockDepartmentService;
import com.trevis.startup.example.impl.MockServiceService;
import com.trevis.startup.example.impl.MockUserService;
import com.trevis.startup.example.services.DepartmentService;
import com.trevis.startup.example.services.ServiceService;
import com.trevis.startup.example.services.UserService;

@Configuration
public class DependenciesConfiguration {

    // mocks
    @Bean
    public UserService userService() {
        return new MockUserService();
    }

    @Bean
    public DepartmentService departmentService() {
        return new MockDepartmentService();
    }

    @Bean
    public ServiceService serviceService() {
        return new MockServiceService();
    }

    // implementacao de fato
    // @Bean
    // public UserService userService() {
    //     return new UserService();
    // }

    // @Bean
    // public DepartmentService departmentService() {
    //     return new DepartmentService();
    // }

    // @Bean
    // public ServiceService serviceService() {
    //     return new ServiceService();
    // }

    // @Bean
    // public PasswordService passwordService() {
    //     return new PasswordService();
    // }

    // @Bean
    // public AuthService authService() {
    //     return new AuthService();
    // }
}