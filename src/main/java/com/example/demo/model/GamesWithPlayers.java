package com.example.demo.model;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.*;

public class GamesWithPlayers {
  private Long id;
  private Boolean isWin;
  private UserEntity whoWin;
  private List<UserWithoutGames> players;
  private SapperSchemesEntity sapperSchemes;

  public static GamesWithPlayers toModel(GamesEntity entity) {
    GamesWithPlayers model = new GamesWithPlayers();
    model.setId(entity.getId());
    model.setIsWin(entity.getIsWin());
    model.setWhoWin(entity.getWhoWin());
    model.setPlayers(entity.getPlayers().stream().map(UserWithoutGames::toModel).collect(Collectors.toList()));
    model.setSapperSchemes(entity.getSapperSchemes());
    return model;
  }
  public Long getId() {
    return id;
  }

  public Boolean getIsWin() {
    return isWin;
  }

  public UserEntity getWhoWin() {
    return whoWin;
  }

  public List<UserWithoutGames> getPlayers() {
    return players;
  }

  public SapperSchemesEntity getSapperSchemes() {
    return sapperSchemes;
  }

  public void setId(Long id) {
     this.id = id;
  }

  public void setIsWin(Boolean isWin) {
    this.isWin = isWin;
  }
  public void setWhoWin(UserEntity user) {
    this.whoWin = user;
  }

  public void setPlayers(List<UserWithoutGames> players) {
    this.players = players;
  }

  public void setSapperSchemes(SapperSchemesEntity sapperSchemes) {
    this.sapperSchemes = sapperSchemes;
  }
}
