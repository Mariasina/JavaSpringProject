package com.trevis.startup.example.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.trevis.startup.example.model.ServiceModel;

@Repository
public interface ServiceJPARepository extends JpaRepository<ServiceModel,Long> {
    List<ServiceModel> findByNameContaining(String name); // Esta função será usada no método get em ServiceService.java
}
