package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.dto.DepartmentDTO;
import com.trevis.startup.example.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DepartmentServiceController {

    @Autowired
    DepartmentService validator;

    @GetMapping("/department")
    public DepartmentDTO returnDepartment() {
        return new DepartmentDTO("Success", validator.getAll());
    }

}
