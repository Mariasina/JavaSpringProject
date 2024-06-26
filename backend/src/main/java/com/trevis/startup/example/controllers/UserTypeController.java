// package com.trevis.startup.example.controllers;

// import org.springframework.web.bind.annotation.RestController;

// import com.trevis.startup.example.dto.response.MessageResponse;
// import com.trevis.startup.example.services.UserTypeService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;


// //  ----------> usamos essa rota para cadastrar os tipos de usuário, mas ela não é necessario para os requisitos do sistema


// @RestController
// public class UserTypeController {
//     @Autowired
//     UserTypeService typeService;

   
//     @PostMapping("/api/type")
//     public ResponseEntity<MessageResponse> createUserType(@RequestParam String type) {
//        typeService.create(type);
//         return ResponseEntity.ok().body(new MessageResponse("okayyy"));
//     }
    
// }
