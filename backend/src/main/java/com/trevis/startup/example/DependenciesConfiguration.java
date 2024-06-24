package com.trevis.startup.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trevis.startup.example.impl.DefaultAuthService;
import com.trevis.startup.example.impl.DefaultPasswordService;
import com.trevis.startup.example.impl.MockDepartmentService;
import com.trevis.startup.example.impl.MockServiceService;
import com.trevis.startup.example.impl.MockUserService;
import com.trevis.startup.example.services.AuthService;
import com.trevis.startup.example.services.DepartmentService;
import com.trevis.startup.example.services.PasswordService;
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

    @Bean
    public PasswordService passwordService() {
        return new DefaultPasswordService();
    }

    @Bean
    public AuthService authService() {
        return new DefaultAuthService();
    }
}