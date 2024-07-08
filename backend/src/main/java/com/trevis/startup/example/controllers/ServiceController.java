package com.trevis.startup.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.trevis.startup.example.services.ServiceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.trevis.startup.example.dto.Service;
import com.trevis.startup.example.impl.JWTGenerator;
import com.trevis.startup.example.model.DepartmentModel;
import com.trevis.startup.example.model.ServiceModel;
import com.trevis.startup.example.model.UserModel;
import com.trevis.startup.example.repositories.UserJPARepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ServiceController {
    @Autowired
    ServiceService serviceRepo;

    @Autowired
    JWTGenerator jwt;

    @Autowired
    UserJPARepository repoUser;

    @PostMapping("/service")
    public String createService(@RequestHeader("token") String token, @RequestBody Service service) {
        
        var payload = jwt.verificate(token);
        if (payload == null) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "invalid token"
                );
        }

        if (payload.role() != 1) {
            throw new ResponseStatusException(
                HttpStatus.FORBIDDEN,
                "You don't have permission to create a new user"
            );
        }

        serviceRepo.Create(service, (long)payload.id());

        return "Service created";
    }

    @GetMapping("/service")
    public List<ServiceModel> getMethodName(@RequestHeader("token") String token, @RequestParam String query, @RequestParam Integer page, @RequestParam Integer size) {
        var payload = jwt.verificate(token);
        if (payload == null) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "invalid token"
                );
        }

        Optional<UserModel> optional = repoUser.findById((long)payload.id());
        UserModel user = optional.get();

        DepartmentModel userDepart =  user.getDepartment();
        return serviceRepo.Get(query, page, size, userDepart);
    }
    
    @DeleteMapping("/service/{id}")
    public String deleteMethod (@RequestHeader("token") String token, @PathVariable Integer id) {
        
        var payload = jwt.verificate(token);

        if (payload == null) {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "invalid token"
                );
        }

        serviceRepo.Delete((long)id, (long)payload.id());

        return "Service deleted";
    }

    @PutMapping("/service/{id}")
    public String putMethodName(@RequestHeader("token") String token, @PathVariable Integer id, @RequestBody Service service) {
        try {
            var payload = jwt.verificate(token);

            if (payload == null) {
                throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid token"
                    );
            }

            if (serviceRepo.Update((long)id, (long)payload.id(), service)) {
                return "Service updated!";
            }
            
            return "Error: Service could not be updated!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Deu ruim!";
        }
        
    }
}
