package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.dto.DepartmentGet;
import com.trevis.startup.example.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departRepo;

    @GetMapping("/department")
    public DepartmentGet getDepartment() {
        return new DepartmentGet("Success!", departRepo.GetAll());
    }
    
}
