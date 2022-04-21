package com.example.demo.service;

import java.util.Date;

import com.example.demo.entity.SessionsEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.SessionsRepo;
import com.example.demo.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionsService {
  @Autowired
  private SessionsRepo sessionsRepo;
  @Autowired
  private UserRepo userRepo;

  public SessionsEntity addSession(Long userId){
    UserEntity user = userRepo.findById(userId).get();
    SessionsEntity session = new SessionsEntity();
    session.setUser(user);
    session.setDate(new Date());

    return sessionsRepo.save(session);
  }
  
}
