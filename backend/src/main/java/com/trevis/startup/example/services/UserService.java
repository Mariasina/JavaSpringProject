package com.trevis.startup.example.services;

import com.trevis.startup.example.dto.UserCreate;
import com.trevis.startup.example.model.UserData;

public interface UserService {
    
    public Boolean create(UserCreate user);
    public Boolean updatePassword(Long id, String newPassword);
    public UserData get(String username);
}
