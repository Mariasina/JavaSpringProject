package com.trevis.startup.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.trevis.startup.example.filters.AuthFilter;

@Configuration
public class FiltersConfiguration {
    @Autowired
    AuthFilter authFilter;

    @Bean
    @Scope("singleton")
    protected FilterRegistrationBean<AuthFilter> registerAuthFilter() {
        var registrationBean = new FilterRegistrationBean<AuthFilter>();

        registrationBean.setFilter(authFilter);
        registrationBean.addUrlPatterns(
            "/api/user/*",
            "/api/department/*",
            "/api/type/*",
            "/api/service/*"
        );
        registrationBean.setOrder(1);

        return registrationBean;
    }
}
