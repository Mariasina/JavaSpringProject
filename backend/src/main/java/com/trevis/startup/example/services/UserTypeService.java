package com.trevis.startup.example.services;

import com.trevis.startup.example.model.UserType;

public interface UserTypeService {
    UserType getById(Long id);
    UserType create(String type);
}
