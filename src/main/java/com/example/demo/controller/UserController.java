package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.SapperSchemesService;
import com.example.demo.service.SessionsService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  private SapperSchemesService sapperSchemesService;
  @Autowired
  private SessionsService sessionsService;
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
      return ResponseEntity.ok(userRepo.findAll());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("error");
    }
  }

  @GetMapping("/checkUser")
  public ResponseEntity checkUser(@RequestParam Long userId){
    try {
      Long id = userService.checkUser(userId);
      sessionsService.addSession(id);
      return ResponseEntity.ok(id);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("error");
    }
  }

  @GetMapping("/getGame")
  public ResponseEntity checkUser(@RequestParam int width, int height){
    try {
      return ResponseEntity.ok(sapperSchemesService.createScheme(width,height));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("error");
    }
  }

}
