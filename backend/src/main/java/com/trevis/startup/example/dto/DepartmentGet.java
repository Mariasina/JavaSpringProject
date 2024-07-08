package com.trevis.startup.example.dto;

import java.util.List;

import com.trevis.startup.example.model.DepartmentModel;

public record DepartmentGet(String message, List<DepartmentModel> data) { } 
//DeparmentManager deve ser acessado pelo metodo get de manager 
