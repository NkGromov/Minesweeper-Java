package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;

  public Long checkUser(Long id) {
    UserEntity user = userRepo.findById(id).orElse(null);
    if(id == null || user == null){
     return this.createUser().getId();
    }
    
    return id;
  }

  private UserEntity createUser() {
   return userRepo.save(new UserEntity());
  }
  
}
