package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.model.ServiceData;
import com.trevis.startup.example.services.ServiceService;

public class MockServiceService implements ServiceService {

    private List<ServiceData> services = new ArrayList<>();

    @Override
    public List<ServiceData> get(String query, Integer pageIndex, Integer pageSize) {
        if(this.services.size() < 0) {
            return null;
        }

        if(pageIndex == null) {
            pageIndex = 1;
        }

        if(query.isEmpty() || query == null) {
            return paginate(pageIndex, pageSize, this.services);
        }

        return paginate(pageIndex, pageSize, searchService(query));
    }

    // ..lista servicos que contem a query no nome..
    public List<ServiceData> searchService(String query) {
        return services.stream().filter(s -> s.getLabel().contains(query)).toList();
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