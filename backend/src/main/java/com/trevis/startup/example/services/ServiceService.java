package com.trevis.startup.example.services;

import java.util.List;

import com.trevis.startup.example.model.ServiceData;

public interface ServiceService {
    
    public List<ServiceData> get(String query, Integer pageIndex, Integer pageSize);
}
