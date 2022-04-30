package com.example.demo.controller;

import com.example.demo.entity.GameTemplatesEntity;
import com.example.demo.service.GameTemplatesService;

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
@RequestMapping("/templates")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GameTemplatesController {
  @Autowired
  private GameTemplatesService gameTemplatesService;

  @GetMapping("/get")
  public ResponseEntity createGame(@RequestParam Long modeId) {
    try {
      return ResponseEntity.ok(gameTemplatesService.getTemplate(modeId));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/create")
  public ResponseEntity createGame(@RequestBody GameTemplatesEntity template) {
    try {
      return ResponseEntity.ok(gameTemplatesService.setTemplate(template));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
