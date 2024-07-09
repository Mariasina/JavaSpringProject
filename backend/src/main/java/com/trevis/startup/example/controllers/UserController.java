package com.trevis.startup.example.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.trevis.startup.example.dto.ChangePass;
import com.trevis.startup.example.dto.PasswordResponse;
import com.trevis.startup.example.dto.UserCreate;
import com.trevis.startup.example.impl.JWTGenerator;
import com.trevis.startup.example.model.UserModel;
import com.trevis.startup.example.repositories.UserJPARepository;
import com.trevis.startup.example.services.PasswordService;
import com.trevis.startup.example.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
public class UserController {

    @Autowired
    UserService UserRepo;

    @Autowired
    JWTGenerator jwt;

    @Autowired
    PasswordService repoPass;

    @Autowired
    UserJPARepository repoUser;
    
    @PostMapping("user")
    public String createUser(@RequestHeader("token") String token, @RequestBody UserCreate user) {
        System.out.println(token);
        var payload = jwt.verificate(token);
        if (payload == null) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "invalid token"
                );
        }
        
        if (payload.role() != 0) {
            throw new ResponseStatusException(
                HttpStatus.FORBIDDEN,
                "You don't have permission to create a new user"
            );
        }

            
        if (!UserRepo.verifyUserAccount(user)) {
            return "The user already exists!";
        }
        
        if (!UserRepo.verifyDepartment(user.department())) {
            return "Department not found!";
        }
        
        if (!UserRepo.verifyRole(user.role())) {
            return "Invalid role!";
        }

        if(UserRepo.Create(user) == null){
            return "Error: account could not be created!";
        }

        return "Succes: account created!";
    }

    // TREVIS disse para tirar id da url, usar só o do token
    @PatchMapping("user")
    public PasswordResponse putMethodName(@RequestHeader("token") String token, @RequestBody ChangePass password) {

        var payload = jwt.verificate(token);

        if (payload == null) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "invalid token"
                );
        }

        var listPass = repoPass.verifyRules(password.password());
        
        if (!(listPass.size() == 0)) {
            return new PasswordResponse("Invalid password. Password does not meet the requirements",listPass);
        }

        var newPass = repoPass.applyCryptography(password.password());
        Optional<UserModel> optional = repoUser.findById((long)payload.id());

        var user = optional.get();
        user.setPassword(newPass);

        repoUser.save(user);
        
        return new PasswordResponse("Success! Updated user", listPass);
    }
}
