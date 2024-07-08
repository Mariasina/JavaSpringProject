package com.trevis.startup.example.dto;



public record UserCreate(String login, Long department, Integer role) { }
// Esse dto foi criado para ser passado no método de criação UserService pois a primeira senha do usuário é padrão