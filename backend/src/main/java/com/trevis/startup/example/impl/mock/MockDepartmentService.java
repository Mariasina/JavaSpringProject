package com.trevis.startup.example.impl.mock;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.model.DepartmentModel;
import com.trevis.startup.example.services.DepartmentService;

public class MockDepartmentService implements DepartmentService {
    List<DepartmentModel> departments = new ArrayList<>();

    public MockDepartmentService() {
        var department = new DepartmentModel();
        department.setId(2l);
        department.setName("ETS");

        department = new DepartmentModel();
        department.setId(1l);
        department.setName("BDO");
    }

    @Override
    public List<DepartmentModel> GetAll() {
        return departments;
    }
}
