package com.trevis.startup.example.services;

import java.util.List;

import com.trevis.startup.example.dto.response.DataDepartment;
import com.trevis.startup.example.exceptions.NoSuchEntityException;
import com.trevis.startup.example.model.Department;

public interface DepartmentService {
    Department getById(Long id) throws NoSuchEntityException;
    List<DataDepartment> getAll();
    public Department createDepartment(String name);
}
