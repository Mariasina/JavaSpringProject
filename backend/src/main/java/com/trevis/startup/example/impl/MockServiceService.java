package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.model.Service;
import com.trevis.startup.example.model.User;
import com.trevis.startup.example.services.ServiceService;

public class MockServiceService implements ServiceService {
    private List<Service> services =  new ArrayList<>();
    
    public MockServiceService() {
        
    }

    @Override
    public void create(Long id, String name, String description, Boolean isInternal, User createdBy) {
        var newService = new Service();
        newService.setId(id);
        newService.setName(name);
        newService.setDescription(description);
        newService.setIsInternal(isInternal);
        newService.setCreatedBy(createdBy);
        services.add(newService);
    }

    @Override
    public List<Service> get(String query, int pageIndex, int pageSize) {
        if(query != null){
            pageIndex *= pageSize;
            var requiredServices = services.stream().filter(u -> u.getName().contains(query)).toList();

            List<Service> pageServices =  new ArrayList<>();
            for (int i = pageIndex - pageSize; i < pageIndex; i++) {
                pageServices.add(requiredServices.get(i));
            }
            return pageServices;
        }
        else{
            List<Service> pageServices =  new ArrayList<>();
            for (int i = pageIndex - pageSize; i < pageIndex; i++) {
                pageServices.add(services.get(i));
            }
            return pageServices;
        }
    }

}