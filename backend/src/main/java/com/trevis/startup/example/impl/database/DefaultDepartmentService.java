package com.trevis.startup.example.impl.database;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.dto.response.DataDepartment;
import com.trevis.startup.example.exceptions.NoSuchEntityException;
import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.repositories.DepartmentJPARepository;
import com.trevis.startup.example.services.DepartmentService;

public class DefaultDepartmentService implements DepartmentService {

    @Autowired
    DepartmentJPARepository repo;

    @Override
    public List<DataDepartment> getAll() {
        List<Department> allDepartments = repo.findAll();

        return allDepartments.stream()
            .map( s -> DataDepartment.buildFromEntity(s))
            .collect(Collectors.toList());
    }

    public Department getById(Long id) throws NoSuchEntityException {
        var departmentFetch = repo.findById(id);
        if (!departmentFetch.isPresent()) {
            throw new NoSuchEntityException("Department not found.");
        }

        return departmentFetch.get();
    }

    public Department createDepartment(String name) {
        var department = new Department();
        department.setName(name);

        var createdDepartment = repo.save(department);
        return createdDepartment;
    }
}
