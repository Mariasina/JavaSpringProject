package com.trevis.startup.example.repositories;

import java.security.Provider.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ServiceJPARepository extends JpaRepository<Service, Long>{
    List<Service> findByNameContaining(String name);
}
