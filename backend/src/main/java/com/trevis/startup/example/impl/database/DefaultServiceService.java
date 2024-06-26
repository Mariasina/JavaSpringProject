package com.trevis.startup.example.impl.database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.trevis.startup.example.dto.response.DataResponse;
import com.trevis.startup.example.dto.response.DataService;
import com.trevis.startup.example.exceptions.NoSuchEntityException;
import com.trevis.startup.example.exceptions.NoSuchServiceException;
import com.trevis.startup.example.model.Service;
import com.trevis.startup.example.model.User;
import com.trevis.startup.example.repositories.ServiceJPARepository;
import com.trevis.startup.example.services.ServiceService;

public class DefaultServiceService implements ServiceService{

    @Autowired
    ServiceJPARepository repo;

    @Override
    public DataResponse<DataService> get(String query, Integer pageIndex, Integer pageSize) throws NoSuchServiceException{

        if (pageIndex < 1 || pageSize < 1) 
            return new DataResponse<>("Pagination arguments cannot be equal to or less than zero.", null);

        List<DataService> dataService = new ArrayList<>();
        
        Integer helper = (pageIndex * pageSize) - pageSize;
        
        pageIndex *= pageSize;

        List<Service> services;

        if (query.length() == 0)
            services = repo.findAll();
        else
            services = repo.findByNameContaining(query);
        
        if ( services.size() <= helper ) 
            return new DataResponse<>("Invalid page index.", null);
            
            
        if (services.size() <= pageSize){
            dataService = services.stream()
            .map( s -> DataService.buildFromEntity(s))
            .collect(Collectors.toList());
            return new DataResponse<>("Matching services found.", dataService);
        }
        List<Service> pageServices = new ArrayList<>();

        for(int i = pageIndex - pageSize; i < pageIndex; i++){
            if (i == services.size()) 
                break;    
            pageServices.add(services.get(i));
        }

        dataService = pageServices.stream()
            .map( s -> DataService.buildFromEntity(s))
            .collect(Collectors.toList());

        return new DataResponse<>("Matching services found.", dataService);
        
    }

    @Override
    public Service create(String name, String description, Boolean internal, User menager) {
        var newService = new Service();
        newService.setName(name);
        newService.setDescription(description);
        newService.setInternal(internal);
        newService.setManager(menager);
        return repo.save(newService);
    }

    @Override
    public Service findById(Long id) throws NoSuchEntityException {
        var serviceFetch = repo.findById(id);
        if (!serviceFetch.isPresent())
            throw new NoSuchEntityException("Service not found.");

        return serviceFetch.get();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void save(Service entity) {
        repo.save(entity);
    }

    
    
}
