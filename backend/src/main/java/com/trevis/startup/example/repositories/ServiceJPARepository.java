package com.trevis.startup.example.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.trevis.startup.example.model.ServiceData;

@Repository
public interface ServiceJPARepository extends JpaRepository<ServiceData, Long>{
    List<ServiceData> findByLabelContaining(String label);
    @SuppressWarnings("null")
    List<ServiceData> findAll();
}
