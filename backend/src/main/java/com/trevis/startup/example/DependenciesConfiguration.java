package com.trevis.startup.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.trevis.startup.example.impl.IMPLAuth;
import com.trevis.startup.example.impl.IMPLDepartment;
import com.trevis.startup.example.impl.IMPLKeyPairManagement;
import com.trevis.startup.example.impl.IMPLPassword;
import com.trevis.startup.example.impl.IMPLService;
import com.trevis.startup.example.impl.IMPLUser;
import com.trevis.startup.example.impl.JWTGenerator;
import com.trevis.startup.example.services.AuthService;
import com.trevis.startup.example.services.DepartmentService;
import com.trevis.startup.example.services.PasswordService;
import com.trevis.startup.example.services.ServiceService;
import com.trevis.startup.example.services.UserService;

@Configuration
public class DependenciesConfiguration {
    // @Bean
    // @Scope("singleton")
    // public AuthService authService() {
    //     return null; 
    //    // Estamos retornando um valor nulo porque authService não possui um Mock. Você precisa implementar isso mais tarde =)
    // }

    @Bean
    @Scope("singleton")
    public PasswordService passwordService() {
        return new IMPLPassword();
        // Estamos retornando um valor nulo porque passwordService não possui um Mock. Você precisa implementar isso mais tarde =)
    }
    
    @Bean
    @Scope("singleton")
    public ServiceService serviceService() {
        return new IMPLService();
    }

    @Bean
    @Scope("singleton")
    public UserService userService() {
        return new IMPLUser();
    }

    @Bean
    @Scope("singleton")
    public DepartmentService departService() {
        return new IMPLDepartment();
    }

    @Bean
    @Scope("singleton")
    public IMPLKeyPairManagement KeyPairManagement () {
        return new IMPLKeyPairManagement();
    }

    @Bean
    @Scope("singleton")
    public JWTGenerator JWTGenerator () {
        return new JWTGenerator();
    }

    @Bean
    @Scope("singleton")
    public AuthService authService() {
        return new IMPLAuth();
    }
    
}