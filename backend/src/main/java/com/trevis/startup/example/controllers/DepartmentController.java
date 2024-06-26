package com.trevis.startup.example.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.example.dto.response.DataDepartment;
import com.trevis.startup.example.dto.response.DataResponse;
// import com.trevis.startup.example.dto.response.MessageResponse;
import com.trevis.startup.example.services.DepartmentService;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DepartmentController {
    
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/api/department")
    public ResponseEntity<DataResponse<DataDepartment>> getAllDepartments(){
        List<DataDepartment> allDepartments = departmentService.getAll();
        return ResponseEntity.ok().body(new DataResponse<>("Departments found with success", allDepartments));
    }

    // // Usamos essa rota para popular o banco com os departamentos, mas ela não
    // // é necessária para os requisitos do projeto.

    // @PostMapping("/api/department")
    // public ResponseEntity<MessageResponse> createDepartment(@RequestParam String name) {
    //     departmentService.createDepartment(name);
    //     return ResponseEntity.ok().body(new MessageResponse("Okay"));
    // }
    
}
