package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.model.Department;
import com.trevis.startup.example.model.Service;
import com.trevis.startup.example.services.ServiceService;

public class MockServiceService implements ServiceService {
    private List<Service> services =  new ArrayList<>();

    public MockServiceService() {
        var newService = new Service();
        newService.setId(1l);
        newService.setName("Sites legais");
        services.add(newService);

        newService = new Service();
        newService.setId(2l);
        newService.setName("TI doida");
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