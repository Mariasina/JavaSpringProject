package com.trevis.startup.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// import com.trevis.startup.example.dto.Login;
import com.trevis.startup.example.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserServiceController {
    
    @Autowired
    UserService validator;

    // @PostMapping("/auth")
    // public Login TryLogin(@RequestBody Login login) {
    //     return 
    // }

    @PostMapping("/user")
    public String postMethodName(@RequestParam String login, @RequestParam String department, @RequestParam String role) {
        
        return "a";
    }
    
}
