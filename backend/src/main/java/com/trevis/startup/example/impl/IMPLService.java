package com.trevis.startup.example.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.trevis.startup.example.dto.Service;
import com.trevis.startup.example.model.DepartmentModel;
import com.trevis.startup.example.model.ServiceModel;
import com.trevis.startup.example.model.UserModel;
import com.trevis.startup.example.repositories.ServiceJPARepository;
import com.trevis.startup.example.repositories.UserJPARepository;
import com.trevis.startup.example.services.ServiceService;

public class IMPLService implements ServiceService{
    @Autowired
    ServiceJPARepository repoService;

    @Autowired
    UserJPARepository repoUser;

    // Criar serviço
    @Override
    public ServiceModel Create(Service service, Long id) {
        Optional<UserModel> optional = repoUser.findById(id);
        UserModel user = optional.get();

        ServiceModel serv = new ServiceModel();
        serv.setName(service.name());
        serv.setDescription(service.description());
        serv.setIntern(service.intern());
        serv.setManager(user);

        repoService.save(serv);

        return serv;
    }

    // Deleta usuário
    @Override
    public Boolean Delete(Long idService, Long idAuth ) {
        Optional<ServiceModel> opitional = repoService.findById(idService);
        ServiceModel serv = opitional.get();

        var idManager = serv.getManager().getId();

        if (idManager != idAuth) {
            return false;
        }

        repoService.deleteById(idService);
        return true;    
    }

    @Override
    public Boolean Update(Long idService, Long idAuth, Service service) {
        try {
            Optional<ServiceModel> opitional = repoService.findById(idService);

            ServiceModel serv = opitional.get();

            if (serv == null) {
                return false;
            }

            var idManager = serv.getManager().getId();

            if (idManager != idAuth) {
                return false;
            }

            serv.setName(service.name());
            serv.setDescription(service.description());
            serv.setIntern(service.intern());
            repoService.save(serv);

            return true;
            
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    // Retorna lista de serviços
    @Override
    public List<ServiceModel> Get(String query, Integer pageIndex, Integer pageSize, DepartmentModel departUser) {
        List<ServiceModel> servicesFiltered = filter(query)
                        .stream()
                        .filter(
                            x -> x.getIntern() ? (departUser.getId() == x.getManager().getDepartment().getId()) : true)
                        .toList();

        return paginate(pageIndex, pageSize, servicesFiltered);
    }

    public List<ServiceModel> filter(String query) {
        List <ServiceModel> services = repoService.findAll();

        if (query == null || query.isEmpty()) {
            return services;
        }

        return services.stream().filter(s->s.getName().toLowerCase().contains(query.toLowerCase())).toList();
    }

    public List<ServiceModel> paginate (Integer index, Integer size, List<ServiceModel> services) {
        if (services.size() < size) {
            return services;
        }

        if (index <= 0) {
            index = 1;
        }

        var qty = index * size;
        List<ServiceModel> servs = new ArrayList<>();
        for(int i = (qty - size); i < qty; i++ ) {
            servs.add(services.get(i));
        }
        return services;
    }
}