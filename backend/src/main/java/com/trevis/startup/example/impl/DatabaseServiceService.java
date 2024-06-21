package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.model.ServiceData;
import com.trevis.startup.example.repositories.ServiceJPARepository;
import com.trevis.startup.example.services.ServiceService;

public class DatabaseServiceService implements ServiceService {
    
    @Autowired
    ServiceJPARepository repo;

    @Override
    public List<ServiceData> get(String query, Integer pageIndex, Integer pageSize) {
        if(pageIndex == null) {
            pageIndex = 1;
        }

        if(query.isEmpty() || query == null) {
            return paginate(pageIndex, pageSize, repo.findAll());
        }

        return paginate(pageIndex, pageSize, searchService(query));
    }

    // ..lista servicos que contem a query no nome..
    public List<ServiceData> searchService(String query) {
        return repo.findByLabelContaining(query);
    }

    public List<ServiceData> paginate(Integer pageIndex, Integer pageSize, List<ServiceData> filteredServices) {
        if (filteredServices.size() < pageSize) { 
            return filteredServices;
        }

        // ..calcula o range de indices dos servicos 
        // com base na quantidade requerida e no index..
        Integer qty = (pageIndex * pageSize); 

        // ..popula nova lista com esses itens..
        List<ServiceData> paginatedServices = new ArrayList<>();
        for (int i = (qty - pageSize); i < qty; i++) {
            paginatedServices.add(filteredServices.get(i));
        }

        return paginatedServices;
    }
}
