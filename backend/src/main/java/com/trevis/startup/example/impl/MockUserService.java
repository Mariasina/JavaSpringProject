package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.model.DepartmentData;
import com.trevis.startup.example.model.UserData;
import com.trevis.startup.example.services.PasswordService;
import com.trevis.startup.example.services.UserService;

public class MockUserService implements UserService {
    
    @Autowired
    PasswordService passService;
    
    private List<UserData> users = new ArrayList<>();
    
    @Override
    public Boolean create(Long id, String username, Integer role, DepartmentData department, String password) {
        var user = new UserData();
        user.setId(id);
        user.setUsername(username);
        user.setRole(role);
        user.setDepartment(department);

        if(!passService.verifyRules(password)){
            return false;
        } 

        String encryptedPassword;
        encryptedPassword = passService.applyCryptography(password);
        user.setPassword(encryptedPassword);

        users.add(user);

        return true;
    }

    @Override
    public Boolean updatePassword(Long id, String newPassword) {
        createUser(1l, "jessiquinha123", 0, new DepartmentData(), "Haha@123");

        UserData loginUser = null;
        for (UserData user : users) {
            if (user.getId() == id) {
                loginUser = user;
                break;
            }
        }

        if(loginUser == null) {
            return false;
        }

        if(!passService.verifyRules(newPassword)){
            return false;
        } 
        
        String encryptedPassword = passService.applyCryptography(newPassword);
        loginUser.setPassword(encryptedPassword);

        return true;
    }

    @Override
    public UserData get(String username) {
        createUser(1l, "username", 0, new DepartmentData(), "Haha@123");

        for (UserData user : users) {
            if (user.getUsername() == username) {
                return user;
            }
        }

        return null;
    }

    public void createUser(Long id, String username, Integer role, DepartmentData department, String password) {
        var user = new UserData();
        user.setId(id);
        user.setUsername(username);
        user.setRole(role);
        user.setDepartment(department);

        users.add(user);
    }
    
}
