package com.trevis.startup.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.model.DepartmentData;
import com.trevis.startup.example.repositories.DepartmentJPARepository;
import com.trevis.startup.example.services.DepartmentService;

public class DatabaseDepartmentService implements DepartmentService {
    
    @Autowired
    DepartmentJPARepository repo;

    @Override
    public List<DepartmentData> getAll() {
        return repo.findAll();
    }
}
