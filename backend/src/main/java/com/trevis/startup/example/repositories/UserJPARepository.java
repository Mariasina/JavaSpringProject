package com.trevis.startup.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trevis.startup.example.model.User;

public interface UserJPARepository extends JpaRepository<User, Long>{
    List<User> findByUsernameContaining(String search);
}
