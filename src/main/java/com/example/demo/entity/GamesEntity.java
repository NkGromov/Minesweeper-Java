package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class GamesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Boolean isWin;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity whoWin;
  @ManyToMany
  @JoinColumn(name = "players_id")
  private List<UserEntity> players;
  @ManyToOne
  @JoinColumn(name = "mode_id")
  private ModesEntity mode;
  @OneToOne
  @JoinColumn(name = "scheme_id")
  private SapperSchemesEntity sapperSchemes;

  public GamesEntity(UserEntity user, ModesEntity mode, SapperSchemesEntity scheme) {
    this.players = new ArrayList<UserEntity>();
    this.players.add(user);
    this.mode = mode;
    this.sapperSchemes = scheme;
    this.isWin = false;
  }

  public GamesEntity() {}

  public Long getId() {
    return id;
  }

  public Boolean getIsWin() {
    return isWin;
  }

  public UserEntity getWhoWin() {
    return whoWin;
  }

  public  List<UserEntity> getPlayers() {
    return players;
  }

  public ModesEntity getMode() {
    return mode;
  }

  public SapperSchemesEntity getSapperSchemes() {
    return sapperSchemes;
  }

  public void setIsWin(Boolean isWin) {
    this.isWin = isWin;
  }
}
