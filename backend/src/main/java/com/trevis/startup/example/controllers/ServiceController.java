package com.trevis.startup.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.dto.payload.ServicePayload;
import com.trevis.startup.example.dto.payload.ServicePayloadPut;
import com.trevis.startup.example.dto.response.DataResponse;
import com.trevis.startup.example.dto.response.DataService;
import com.trevis.startup.example.dto.response.MessagesResponse;
import com.trevis.startup.example.exceptions.NoSuchEntityException;
import com.trevis.startup.example.model.Service;
import com.trevis.startup.example.services.ServiceService;
import com.trevis.startup.example.services.UserService;
import com.trevis.startup.example.sessions.UserSession;

@RestController
public class ServiceController {
    @Autowired
    UserSession userSession;

    @Autowired
    ServiceService serviceService;

    @Autowired
    UserService userService;
    
    @GetMapping("/api/service")
    public ResponseEntity<DataResponse<DataService>> getQueryServices(
            @RequestParam String query,
            @RequestParam Integer pageIndex,
            @RequestParam Integer pageSize
    ){
        try {
            DataResponse<DataService> response = serviceService.get(query, pageIndex, pageSize);
            return ResponseEntity.ok().body(response);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/api/service")
    public ResponseEntity<MessagesResponse> createService(@RequestBody  ServicePayload payload) throws NoSuchEntityException {
        var requestingUserId = userSession.getId();
        var requestingUser = userService.findById(requestingUserId);

        List<String> messages = new ArrayList<>();
        if (requestingUser.getUsertype().getId() != 3) {
            messages.add("Action not allowed.");
            return ResponseEntity.status(403).body(new MessagesResponse(messages));
        }

        var saveService = serviceService.create(
            payload.name(),
            payload.description(),
            payload.internal(),
            requestingUser
        );

        if (saveService == null) {
            messages.add("Could not create service.");
            return ResponseEntity.badRequest().body(new MessagesResponse(messages));
        }

        messages.add("Service created with success.");

        return ResponseEntity.ok().body(new MessagesResponse(messages));
    }

    @DeleteMapping("/api/service/{id}")
    public ResponseEntity<MessagesResponse> deleteService(@PathVariable Long id){
        List<String> messages = new ArrayList<>();
        
        try {
            serviceService.findById(id);
        } catch (NoSuchEntityException ex) {
            messages.add("Service not found.");
            return ResponseEntity.status(404).body(new MessagesResponse(messages));
        }

        serviceService.deleteById(id);

        messages.add("Service deleted with success.");

        return ResponseEntity.ok().body(new MessagesResponse(messages));
    }

    @PutMapping("/api/service/{id}")
    public ResponseEntity<MessagesResponse> putService(
        @RequestBody ServicePayloadPut payload,
        @PathVariable Long id
    ) {
        List<String> messages = new ArrayList<>();
        Service service;

        try {
            service = serviceService.findById(id);
        } catch (NoSuchEntityException ex) {
            return ResponseEntity.notFound().build();
        }
        
        service.setName(payload.name());
        service.setDescription(payload.description());
        service.setInternal(payload.internal());

        serviceService.save(service);

        messages.add("Service updated with success.");
        return ResponseEntity.ok().body(new MessagesResponse(messages));

    }


    // @PostMapping("/api/service")
    // public ResponseEntity<MessagesResponse> createService(@RequestBody  ServicePayloadPut payload){
    //     var saveService = serviceService.create(
    //         payload.name(),
    //         payload.description(),
    //         payload.internal(),
    //         null
    //     );
        
    //     List<String> messages = new ArrayList<>();

    //     if (saveService == null) {
    //         messages.add("Could not create service.");
    //         return ResponseEntity.badRequest().body(new MessagesResponse(messages));
    //     }

    //     messages.add("Service created with success.");

    //     return ResponseEntity.ok().body(new MessagesResponse(messages));
    // }

}