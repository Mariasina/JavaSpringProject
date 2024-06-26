package com.trevis.startup.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trevis.startup.example.model.Department;

@Repository
public interface DepartmentJPARepository extends JpaRepository<Department, Long> {
    
}
