package com.example.demo.controller;

import com.example.demo.service.GamesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GamesController {
  @Autowired
  private GamesService gamesService;
  @PostMapping("/create")
  public ResponseEntity createGame(@RequestBody int width, int height, Long userId) {
    try {
      return ResponseEntity.ok(gamesService.create(width, height, userId));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("error");
    }
  }

  @PostMapping("/refresh")
  public ResponseEntity refresh(@RequestBody Long gameId) {
    try {
      return ResponseEntity.ok("ok");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("error");
    }
  }

  @PutMapping("/win")
  public ResponseEntity changeIsWin(@RequestBody Long gameId, Boolean isWin) {
    try {
      return ResponseEntity.ok(gamesService.changeIsWin(gameId, isWin));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("error");
    }
  }
}
