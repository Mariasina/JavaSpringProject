package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.services.DepartmentService;

public class MockDepartmentService implements DepartmentService {
 
    private static List<Department> departments = new ArrayList<Department>();

    public MockDepartmentService() {
    
    }

    @Override
    public void create(Long id, String name) {
        var newDepartment = new Department();
        newDepartment.setId(id);
        newDepartment.setName(name);
        departments.add(newDepartment);
    }
 
    @Override
    public List<Department> getAll() {
        return departments;
    }

}