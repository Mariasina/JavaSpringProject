package com.trevis.startup.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trevis.startup.example.model.UserType;

public interface UserTypeJPARepository extends JpaRepository<UserType, Long> {
    
}
