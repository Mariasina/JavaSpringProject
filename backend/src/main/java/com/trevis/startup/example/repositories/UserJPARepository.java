package com.trevis.startup.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trevis.startup.example.model.UserModel;

@Repository
public interface UserJPARepository extends JpaRepository<UserModel,Long> {
    List<UserModel> findByLogin(String login);
}

