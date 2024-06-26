package com.trevis.startup.example.impl.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.trevis.startup.example.dto.response.DataDepartment;
import com.trevis.startup.example.exceptions.NoSuchEntityException;
import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.services.DepartmentService;

public class MockDepartmentService implements DepartmentService {
    
    private static List<Department> departments = new ArrayList<>();
    private Long current_id;

    public MockDepartmentService() {
        var newDepartment = new Department();
        newDepartment.setId(1l);
        newDepartment.setName("IT Department");

        departments.add(newDepartment);

        newDepartment = new Department();
        newDepartment.setId(2l);
        newDepartment.setName("Finances Department");

        departments.add(newDepartment);

        newDepartment = new Department();
        newDepartment.setId(3l);
        newDepartment.setName("HR Department");

        departments.add(newDepartment);
        this.current_id = 4l;
    }
    
    @Override
    public List<DataDepartment> getAll(){
        return departments.stream()
            .map( s -> DataDepartment.buildFromEntity(s))
            .collect(Collectors.toList());
    }

    @Override
    public Department getById(Long id) throws NoSuchEntityException {
        for (Department department : departments) {
            if (id == department.getId()) 
                return department;
        }
        return null;
    }

    @Override
    public Department createDepartment(String name) {
        var newDepartment = new Department();
        current_id++;
        newDepartment.setId(current_id);
        newDepartment.setName(name);
        departments.add(newDepartment);
        return newDepartment;
    }
}
