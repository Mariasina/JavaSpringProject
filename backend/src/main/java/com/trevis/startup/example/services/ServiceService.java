package com.trevis.startup.example.services;

import java.util.List;

import com.trevis.startup.example.dto.Service;
import com.trevis.startup.example.model.DepartmentModel;
import com.trevis.startup.example.model.ServiceModel;

public interface ServiceService {
    public List<ServiceModel> Get(String query, Integer pageIndex, Integer pageSize, DepartmentModel departUser);  
    public ServiceModel Create(Service service, Long id);
    public Boolean Delete(Long id, Long idAuth);
    public Boolean Update(Long idService, Long Auth, Service service);
    // public List<ServiceModel> Get(String query, int pageIndex, int pageSize, Object departUser);
    
} 
