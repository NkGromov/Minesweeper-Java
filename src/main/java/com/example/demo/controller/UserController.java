package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepo userRepo;

  @PostMapping
  public ResponseEntity registration(@RequestBody UserEntity user){
    try {
      userRepo.save(user);
      return ResponseEntity.ok(user);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("error");
    }
   
  }

  @GetMapping
  public ResponseEntity getUser(){
    try {
      return ResponseEntity.ok("ok");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("error");
    }
  }
}
