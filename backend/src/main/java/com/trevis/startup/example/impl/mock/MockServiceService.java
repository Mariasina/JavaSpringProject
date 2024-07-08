package com.trevis.startup.example.impl.mock;

import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.example.dto.Service;
import com.trevis.startup.example.model.DepartmentModel;
import com.trevis.startup.example.model.ServiceModel;
import com.trevis.startup.example.model.UserModel;
import com.trevis.startup.example.services.ServiceService;

public class MockServiceService implements ServiceService {

    private List<ServiceModel> allServices = new ArrayList<>();

    public MockServiceService() {
        var department = new DepartmentModel();
        department.setId(2l);
        department.setName("ETS");

        var user = new UserModel();
        user.setId(2l);
        user.setLogin("Mavizoka");
        user.setRole(0);
        user.setDepartment(department);

        var service = new ServiceModel();
        service.setId(1l);
        service.setName("Client register");
        service.setDescription("pipipi");
        service.setIntern(true);
        service.setManager(user);

        allServices.add(service);
    }

    @Override
    public List<ServiceModel> Get(String query, Integer pageIndex, Integer pageSize, DepartmentModel departUser) {

        if (pageIndex == null || pageIndex == 0) {
            pageIndex = 1;
        }
        
        if (query.isEmpty()) {
            return paginate(pageIndex, pageSize, this.allServices);
        }

        return paginate(pageIndex, pageSize, searchService(query));
    }

    public List<ServiceModel> searchService(String query) {
        return allServices.stream()
            .filter(u-> u.getName().contains(query))
            .toList();
    }

    public List<ServiceModel> paginate(Integer pageIndex, Integer pageSize, List<ServiceModel> filteredServices) { 
        // Este método é usado para filtrar todos os serviços nas páginas, mas usando apenas uma Lista
        //É importante ressaltar que estamos usando (pageIndex * pageSize), por conta disso o pageIndex não pode ser 0, estamos tratando esta exceção na linha 39
        if (filteredServices.size() < pageSize) {
            return filteredServices;
        }

        Integer qty = (pageIndex * pageSize) - 1;
        List<ServiceModel> paginateServices = new ArrayList<>();

        for (int i = (qty - pageSize); i < qty; i++) {
            paginateServices.add(filteredServices.get(i));
        }

        return paginateServices;
    }

    @Override
    public ServiceModel Create(Service service, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Create'");
    }

    @Override
    public Boolean Delete(Long id, Long idAuth) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public Boolean Update(Long idService, Long Auth, Service service) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    
}
