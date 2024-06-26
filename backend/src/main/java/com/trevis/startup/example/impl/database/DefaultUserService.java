package com.trevis.startup.example.impl.database;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.exceptions.BadHashConfigurationException;
import com.trevis.startup.example.exceptions.NoSuchEntityException;
import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.model.User;
import com.trevis.startup.example.model.UserType;
import com.trevis.startup.example.repositories.UserJPARepository;
import com.trevis.startup.example.services.PasswordService;
import com.trevis.startup.example.services.UserService;

public class DefaultUserService implements UserService {
    @Autowired
    UserJPARepository repo;

    @Autowired
    PasswordService passwordService;

    public User create(String username, Department department, UserType type) {
        String hashedPassword;
        try {
            hashedPassword = passwordService.applyCryptography("Ets@Bosch2024");
        } catch (BadHashConfigurationException ex) {
            return null;
        }

        var newUser = new User();
        newUser.setUsername(username);
        newUser.setDepartment(department);
        newUser.setUsertype(type);
        newUser.setPassword(hashedPassword);
        return repo.save(newUser);
    }

    public Boolean updatePassword(Long id, String newPassword)
        throws
            NoSuchEntityException,
            BadHashConfigurationException {
        var userFetch = repo.findById(id);
        if (!userFetch.isPresent())
            throw new NoSuchEntityException("User not found.");

        int passwordStrength = passwordService.verifyRules(newPassword);
        if (passwordStrength < 5)
            return false;

        var user = userFetch.get();
        user.setPassword(passwordService.applyCryptography(newPassword));

        repo.save(user);

        return true;
    }

    public User get(String username) throws NoSuchEntityException {
        var matchingUsers = repo.findByUsernameContaining(username);

        if (matchingUsers.size() == 0)
            throw new NoSuchEntityException("Matching user not found.");
        
        return matchingUsers.get(0);
    }

    @Override
    public User findById(Long id) throws NoSuchEntityException{
        var userFetch = repo.findById(id);
        if (!userFetch.isPresent())
            throw new NoSuchEntityException("User not found.");
        return userFetch.get();
    }
}
