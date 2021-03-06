package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String email;
  private Date dateCreated;

  @OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "user")
  private List<SessionsEntity> sessions;

  @ManyToMany(mappedBy = "players")
  private List<GamesEntity> completedGames;

  @OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "whoWin")
  private List<GamesEntity> winGames;

  public UserEntity() {
    this.dateCreated = new Date();
  }
  
  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public List<SessionsEntity> getSessions() {
    return sessions;
  }

  public List<GamesEntity> getCompletedGames() {
    return completedGames;
  }

  public List<GamesEntity> getWinGames() {
    return winGames;
  }
}
