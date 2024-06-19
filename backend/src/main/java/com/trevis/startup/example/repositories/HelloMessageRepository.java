package com.trevis.startup.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trevis.startup.example.model.HelloMessage;

public interface HelloMessageRepository 
    extends JpaRepository<HelloMessage, Long> {}