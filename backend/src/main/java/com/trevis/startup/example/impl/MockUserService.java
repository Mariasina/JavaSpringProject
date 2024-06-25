package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.dto.UserCreate;
import com.trevis.startup.example.model.DepartmentData;
import com.trevis.startup.example.model.UserData;
import com.trevis.startup.example.repositories.DepartmentJPARepository;
import com.trevis.startup.example.services.PasswordService;
import com.trevis.startup.example.services.UserService;

public class MockUserService implements UserService {

    @Autowired
    PasswordService passService;

    @Autowired
    DepartmentJPARepository departRepo;

    private List<UserData> users = new ArrayList<>();

    @Override
    public Boolean create(UserCreate newUser) {
        var user = new UserData();
        user.setUsername(newUser.login());
        user.setRole(newUser.role());
        var department = departRepo.findById(newUser.department());

        if (department.isPresent()) {
            DepartmentData newDepartment = department.get();
            user.setDepartment(newDepartment);
        }

        Random random = new Random();

        String[] characters = { "0", "1", "b", "2", "4", "5", "6", "7", "8",
                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
                "x", "y", "z" };

        String password = "";

        for (int i = 0; i < 8; i++) {
            int position = random.nextInt(0, 36);
            password += characters[position];
        }

        String encryptedPassword;
        encryptedPassword = passService.applyCryptography(password);
        user.setPassword(encryptedPassword);

        users.add(user);

        return true;
    }

    @Override
    public Boolean updatePassword(Long id, String newPassword) {
        createUser(1l, "jessiquinha123", 0, new DepartmentData());

        UserData loginUser = null;
        for (UserData user : users) {
            if (user.getId() == id) {
                loginUser = user;
                break;
            }
        }

        if (loginUser == null) {
            return false;
        }

        if (!passService.verifyRules(newPassword)) {
            return false;
        }

        String encryptedPassword = passService.applyCryptography(newPassword);
        loginUser.setPassword(encryptedPassword);

        return true;
    }

    @Override
    public UserData get(String username) {
        createUser(1l, "username", 0, new DepartmentData());

        for (UserData user : users) {
            if (user.getUsername() == username) {
                return user;
            }
        }

        return null;
    }

    public void createUser(Long id, String username, Integer role, DepartmentData department) {
        var user = new UserData();
        user.setId(id);
        user.setUsername(username);
        user.setRole(role);
        user.setDepartment(department);

        users.add(user);
    }

}
