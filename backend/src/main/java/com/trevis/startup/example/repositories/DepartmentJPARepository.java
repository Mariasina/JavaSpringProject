package com.trevis.startup.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trevis.startup.example.model.DepartmentData;

@Repository
public interface DepartmentJPARepository extends JpaRepository<DepartmentData, Long> {
    
    @SuppressWarnings("null")
    List<DepartmentData> findAll();
}
