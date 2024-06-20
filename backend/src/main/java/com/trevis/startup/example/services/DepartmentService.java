package com.trevis.startup.example.services;

import java.util.List;

import com.trevis.startup.example.model.Department;

public interface DepartmentService {
    void create(Long id, String name);
    List<Department> getAll();
}