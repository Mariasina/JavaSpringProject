package com.trevis.startup.example.services;

import com.trevis.startup.example.model.DepartmentData;
import com.trevis.startup.example.model.UserData;

public interface UserService {
    
    public Boolean create(Long id, String username, Integer role, DepartmentData department, String password);
    public Boolean updatePassword(Long id, String newPassword);
    public UserData get(String username);
}
