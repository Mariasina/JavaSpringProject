package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.dto.ServiceDTO;
import com.trevis.startup.example.services.ServiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ServiceServiceController {
    
    @Autowired
    ServiceService validator;

    @GetMapping("/service")
    public ServiceDTO getMethodName(@RequestParam String query, @RequestParam int page, @RequestParam int size) {
        return new ServiceDTO("Success", validator.get(query, page, size));
    }

    // @PostMapping("/service")
    // public String postMethodName(@RequestBody String entity) {
        
    //     return entity;
    // }

}
