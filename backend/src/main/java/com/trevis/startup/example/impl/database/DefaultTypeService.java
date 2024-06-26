package com.trevis.startup.example.impl.database;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.model.UserType;
import com.trevis.startup.example.repositories.UserTypeJPARepository;
import com.trevis.startup.example.services.UserTypeService;

public class DefaultTypeService implements UserTypeService {
    @Autowired
    UserTypeJPARepository repo;

    public UserType getById(Long id) {
        return repo.getReferenceById(id);
    }

    public UserType create(String type) {
        var newUserType = new UserType();
        newUserType.setType(type);

        return repo.save(newUserType);
    }
}
