package com.trevis.startup.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.trevis.startup.example.filters.AuthFilter;
import com.trevis.startup.example.impl.database.DefaultDepartmentService;
import com.trevis.startup.example.impl.database.DefaultServiceService;
import com.trevis.startup.example.impl.database.DefaultTypeService;
import com.trevis.startup.example.impl.database.DefaultUserService;
// import com.trevis.startup.example.impl.mock.MockDepartmentService;
// import com.trevis.startup.example.impl.mock.MockServiceService;
// import com.trevis.startup.example.impl.mock.MockUserService;
import com.trevis.startup.example.impl.security.JwtAuthService;
import com.trevis.startup.example.impl.security.PBKDF2PasswordService;
import com.trevis.startup.example.services.AuthService;
import com.trevis.startup.example.services.DepartmentService;
import com.trevis.startup.example.services.PasswordService;
import com.trevis.startup.example.services.ServiceService;
import com.trevis.startup.example.services.UserService;
import com.trevis.startup.example.services.UserTypeService;
import com.trevis.startup.example.sessions.UserSession;

@Configuration
public class DependenciesConfiguration {

    @Bean
    @Scope("singleton")
    protected DepartmentService departmentService() {
        return new DefaultDepartmentService();
    }

    @Bean
    @Scope("singleton")
    protected UserTypeService userTypeService() {
        return new DefaultTypeService();
    }

    @Bean
    @Scope("singleton")
    protected UserService userService() {
        return new DefaultUserService();
    }

    @Bean
    @Scope("singleton")
    protected ServiceService serviceService() {
        return new DefaultServiceService();
    }

    @Bean
    @Scope("singleton")
    protected AuthService authService() {
        return new JwtAuthService();
    }

    @Bean
    @Scope("singleton")
    protected PasswordService passwordService() {
        return new PBKDF2PasswordService();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    protected UserSession userSession() {
        return new UserSession();
    }

    @Bean
    @Scope("singleton")
    protected AuthFilter authFilter() {
        return new AuthFilter();
    }
}