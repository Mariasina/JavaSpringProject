package com.trevis.startup.example.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.model.User;

public record DataDepartment(
    Long id,
    String name,
    List<Long> users
) { 

    public static DataDepartment buildFromEntity(Department department) {
        List<Long> usersId = new ArrayList<>();
        for (User user : department.getUsers()) {
            usersId.add(user.getId());
        }
        return new DataDepartment(
            department.getId(),
            department.getName(),
            usersId
        );
    }
}
