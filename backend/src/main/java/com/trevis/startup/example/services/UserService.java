package com.trevis.startup.example.services;

import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.model.User;

public interface UserService {
    void create(Long id, String username, String password, Integer type, Department department);
    void updatePassword(Long id, String newPassword);
    User get(String username);
}