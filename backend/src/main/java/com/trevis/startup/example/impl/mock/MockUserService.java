package com.trevis.startup.example.impl.mock;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.dto.UserCreate;
import com.trevis.startup.example.model.DepartmentModel;
import com.trevis.startup.example.model.UserModel;
import com.trevis.startup.example.services.UserService;

public class MockUserService implements UserService {
    private List<UserModel> users = new ArrayList<>();

    public MockUserService() {
        var department = new DepartmentModel();
        department.setId(2l);
        department.setName("ETS");

        var user = new UserModel();
        user.setId(1l);
        user.setLogin("Mavizoka");
        user.setRole(0);
        user.setDepartment(department);
    }

    @Override
    public UserModel Create(UserCreate user) {

        var newUser = new UserModel();
        newUser.setId(3l);
        newUser.setLogin(user.login());
        newUser.setRole(user.role());
        newUser.setPassword("Mavi@123");

        users.add(newUser); 
        return newUser; 
    }

    @Override
    public boolean UpdatePassword(Long id, String newPassword) {

        UserModel newPassUser = users.stream()
            .filter(u-> u.getId() == id)
            .toList()
            .get(0);
        
        newPassUser.setPassword(newPassword);

        if (!newPassUser.getPassword().equals(newPassword))
            return false;
        return true;
    }

    @Override
    public UserModel Get(String username) {
        return users.stream()
            .filter(u-> u.getLogin().equals(username))
            .toList()
            .get(0);
    }

    @Override
    public boolean verifyUserAccount(UserCreate user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyUserAccount'");
    }

    @Override
    public boolean verifyDepartment(Long depart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyDepartment'");
    }

    @Override
    public boolean verifyRole(Integer role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyRole'");
    }
}