package com.trevis.startup.example.services;

import java.util.List;

import com.trevis.startup.example.model.Service;

public interface ServiceService {
    List<Service> get(String query, int pageIndex, int pageSize);
}