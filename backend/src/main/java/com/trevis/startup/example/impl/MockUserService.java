package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.services.UserService;
import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.model.User;

public class MockUserService implements UserService{
    private List<User> users =  new ArrayList<>();

    public MockUserService(){
        
    }

    @Override
    public void create(Long id, String username, String password, Integer type, Department department) {
        var user = new User();

        user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);
        user.setDepartment(department);
        users.add(user);
    }

    @Override
    public void updatePassword(Long id, String newPassword) {
       for (User user : users) {
            if(user.getId() == id){
                user.setPassword(newPassword);
            }
        }
    }

    @Override
    public User get(String username) {
        for (User user : users) {
            if(user.getUsername() == username){
                return user;
            }
        }
        
        return null;
    }
    
}
