package com.trevis.startup.example.services;

import com.trevis.startup.example.model.Department;

public interface UserService {
    void create(Long id, String username, String password, Integer type, Department department);
    String updatePassword(Long id, String newPassword);
    String get(String username);
}