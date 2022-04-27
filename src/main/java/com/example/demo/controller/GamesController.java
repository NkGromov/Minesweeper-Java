package com.example.demo.controller;

import com.example.demo.service.GamesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GamesController {
  @Autowired
  private GamesService gamesService;
  @PostMapping("/create")
  public ResponseEntity createGame(@RequestParam int width, int height, Long userId) {
    try {
      return ResponseEntity.ok(gamesService.create(width, height, userId));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("error");
    }
  }

  @PutMapping("/win")
  public ResponseEntity changeIsWin(@RequestParam Long gameId, Boolean isWin) {
    try {
      return ResponseEntity.ok(gamesService.changeIsWin(gameId, isWin));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("error");
    }
  }
}
