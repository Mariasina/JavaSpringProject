package com.trevis.startup.example.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.dto.UserCreate;
import com.trevis.startup.example.model.DepartmentData;
import com.trevis.startup.example.model.UserData;
import com.trevis.startup.example.repositories.DepartmentJPARepository;
import com.trevis.startup.example.repositories.UserJPARepository;
import com.trevis.startup.example.services.PasswordService;
import com.trevis.startup.example.services.UserService;

public class DatabaseUserService implements UserService {

    @Autowired
    UserJPARepository repo;

    @Autowired
    PasswordService passService;

    @Autowired
    DepartmentJPARepository departRepo;

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

        System.out.println("Senha:" + password);

        String encryptedPassword;
        encryptedPassword = passService.applyCryptography(password);
        user.setPassword(encryptedPassword);

        repo.save(user);

        return true;
    }

    @Override
    public Boolean updatePassword(Long id, String newPassword) {
        UserData loginUser = repo.findById(id).orElse(null);

        if (loginUser == null) {
            return false;
        }

        if (!passService.verifyRules(newPassword)) {
            return false;
        }else{

            String encryptedPassword = passService.applyCryptography(newPassword);
            loginUser.setPassword(encryptedPassword);
    
            repo.save(loginUser);
    
            return true;
        }

    }

    @Override
    public UserData get(String username) {
        return repo.findByUsername(username);
    }
}
