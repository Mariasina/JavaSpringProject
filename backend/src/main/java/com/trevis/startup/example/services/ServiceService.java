package com.trevis.startup.example.services;

import java.util.List;

import com.trevis.startup.example.model.Service;
import com.trevis.startup.example.model.User;

public interface ServiceService {
    void create(Long id, String name, String description, Boolean isInternal, User createdBy);
    List<Service> get(String query, int pageIndex, int pageSize);
}