package com.trevis.startup.example.impl.mock;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.exceptions.NoSuchEntityException;
import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.model.User;
import com.trevis.startup.example.model.UserType;
import com.trevis.startup.example.services.UserService;

public class MockUserService implements UserService{

    private static List<User> users = new ArrayList<>();

    @Override
    public User create(String username, Department department, UserType type){
        var user = new User();
        user.setId(1l);
        user.setUsername(username);
        user.setDepartment(department);
        user.setUsertype(type);

        users.add(user);
        
        return user;
    }

    @Override
    public Boolean updatePassword(Long id, String newPassword){
        for (User user : users) {
            if (user.getId() == id) {
                user.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }

    @Override
    public User get(String username){
        for (User user : users) {
            if (user.getUsername() == username) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findById(Long id) throws NoSuchEntityException {
        for (User user : users) {
            if (id == user.getId())
                return user;    
        }
        return null;
    }
}
