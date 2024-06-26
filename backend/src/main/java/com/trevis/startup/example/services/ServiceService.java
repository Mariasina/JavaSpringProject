package com.trevis.startup.example.services;

import com.trevis.startup.example.dto.response.DataResponse;
import com.trevis.startup.example.dto.response.DataService;
import com.trevis.startup.example.exceptions.NoSuchEntityException;
import com.trevis.startup.example.exceptions.NoSuchServiceException;
import com.trevis.startup.example.model.Service;
import com.trevis.startup.example.model.User;

public interface ServiceService {
    DataResponse<DataService> get(String query, Integer pageIndex, Integer pageSize) throws NoSuchServiceException;
    Service create(String name, String description, Boolean internal, User menager);
    Service findById(Long id) throws NoSuchEntityException;
    void deleteById(Long id);
    void save(Service service);
}
