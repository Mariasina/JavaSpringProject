package com.trevis.startup.example.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.trevis.startup.example.model.ServiceData;


public interface ServiceJPARepository extends JpaRepository<ServiceData, Long>{
    List<ServiceData> findByLabelContaining(String label);
}
