package com.example.demo.service;

import com.example.demo.entity.GamesEntity;
import com.example.demo.entity.ModesEntity;
import com.example.demo.entity.SapperSchemesEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.GamesWithoutPlayers;
import com.example.demo.repository.GamesRepo;
import com.example.demo.repository.ModesRepo;
import com.example.demo.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamesService {
  @Autowired
  private GamesRepo gamesRepo;
  @Autowired
  private UserRepo userRepo;
  @Autowired
  private ModesRepo modesRepo;
  @Autowired
  private SapperSchemesService sapperSchemesService;
  

  public GamesWithoutPlayers create(int width, int height, Long userId) {
    UserEntity user = userRepo.findById(userId).get();
    ModesEntity mode = modesRepo.findById(Long.valueOf(1)).get();
    SapperSchemesEntity gameScheme = sapperSchemesService.createScheme(width, height);
    GamesEntity game = new GamesEntity(user, mode, gameScheme);

    return GamesWithoutPlayers.toModel(gamesRepo.save(game));
  }

  public GamesWithoutPlayers refresh(int width, int height, Long userId, Long gameId, Boolean isWin) {
    GamesEntity game = gamesRepo.findById(gameId).get();
    game.setIsWin(isWin);
    gamesRepo.save(game);
    
    return this.create(width, height, userId);
  }

  public GamesWithoutPlayers changeIsWin(Long gameId, Boolean isWin) {
    GamesEntity game = gamesRepo.findById(gameId).get();
    game.setIsWin(isWin);
    return GamesWithoutPlayers.toModel(gamesRepo.save(game));
  }

}
