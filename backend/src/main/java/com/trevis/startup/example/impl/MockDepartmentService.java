package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.model.DepartmentData;
import com.trevis.startup.example.services.DepartmentService;

public class MockDepartmentService implements DepartmentService {
    
    List<DepartmentData> departments = new ArrayList<>();

    @Override
    public List<DepartmentData> getAll() {
        return this.departments;
    }
}
