package com.trevis.startup.example.services;


import com.trevis.startup.example.dto.UserCreate;
import com.trevis.startup.example.model.UserModel;

public interface UserService {
   public UserModel Create(UserCreate user);
   public boolean UpdatePassword (Long id, String newPassword);
   public UserModel Get(String username);
   
   public boolean verifyUserAccount(UserCreate user);
   public boolean verifyDepartment(Long depart);
   public boolean verifyRole(Integer role);
}
