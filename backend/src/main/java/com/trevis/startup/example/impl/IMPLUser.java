package com.trevis.startup.example.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.dto.UserCreate;
import com.trevis.startup.example.impl.util.RandomPasswordGenerator;
import com.trevis.startup.example.model.UserModel;
import com.trevis.startup.example.repositories.DepartmentJPARepository;
import com.trevis.startup.example.repositories.UserJPARepository;
import com.trevis.startup.example.services.PasswordService;
import com.trevis.startup.example.services.UserService;

public class IMPLUser implements UserService {

    @Autowired
    UserJPARepository repoUser;

    @Autowired
    DepartmentJPARepository repoDepart;

    @Autowired
    PasswordService repoPass;

    @Override
    public UserModel Create(UserCreate user) {
        UserModel userCreate = new UserModel();
        userCreate.setLogin(user.login());

        var optional = repoDepart.findById(user.department());
        if (!optional.isPresent())
            return null;

        userCreate.setDepartment(optional.get());
        userCreate.setRole(user.role());

        var randomPass = RandomPasswordGenerator.generateRandomPassword(8);
        System.out.println("Pass:" + randomPass);
        userCreate.setPassword(
            repoPass.applyCryptography(randomPass)
        );

        repoUser.save(userCreate);

        return userCreate;
    }

    @Override
    public boolean UpdatePassword(Long id, String newPassword) {
        return false;
    }

    @Override
    public UserModel Get(String username) {
        List<UserModel> users = repoUser.findByLogin(username);

        return users.get(0);
    }

    @Override
    public boolean verifyUserAccount(UserCreate user) {
        List<UserModel> users = repoUser.findByLogin(user.login());

        if (users.size() <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyDepartment(Long depart) {
        var optional = repoDepart.findById(depart);
        return optional.isPresent();
    }

    @Override
    public boolean verifyRole(Integer role) {
        List<Integer> roles = new ArrayList<>();

        roles.add(1);
        roles.add(2);
        roles.add(3);
        
        return roles.contains(role);
    }

}