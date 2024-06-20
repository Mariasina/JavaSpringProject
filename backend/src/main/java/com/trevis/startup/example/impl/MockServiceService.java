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
        //creates a new service and adds it to the list
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
        //multiplies the page index with page size to know where the return list is goin to end
        pageIndex *= pageSize;

        if(query != null){

            //filters the mock list to return only itens that contain the query
            var requiredServices = services.stream().filter(u -> u.getName().contains(query)).toList();

            List<Service> pageServices =  new ArrayList<>();
            //ads to the new list itens from pageIndex - pageSize to pageIndex.  
            //ex: pageIndex = 1, pageSize = 10. multipling the 2 returns 10, the for loop should run from 0 to 9
            for (int i = pageIndex - pageSize; i < pageIndex; i++) {
                pageServices.add(requiredServices.get(i));
            }
            return pageServices;
        }
        else{
            //if no query was sent, returns the normal mock list in the same way
            List<Service> pageServices =  new ArrayList<>();
            for (int i = pageIndex - pageSize; i < pageIndex; i++) {
                pageServices.add(services.get(i));
            }
            return pageServices;
        }
    }

}