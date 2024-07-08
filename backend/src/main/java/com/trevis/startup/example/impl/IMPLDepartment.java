package com.trevis.startup.example.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.model.DepartmentModel;
import com.trevis.startup.example.repositories.DepartmentJPARepository;
import com.trevis.startup.example.services.DepartmentService;

public class IMPLDepartment implements DepartmentService {
    @Autowired
    DepartmentJPARepository repoDepart;

    @Override
    public List<DepartmentModel> GetAll() {
        return repoDepart.findAll();
    }
}