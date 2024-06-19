package com.trevis.startup.example.services;

public interface UserService {
    void create(Long id);
    String updatePassword(Long id, String newPassword);
    String get(String username);
}