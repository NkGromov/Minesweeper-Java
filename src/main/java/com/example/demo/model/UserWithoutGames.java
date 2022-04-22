package com.example.demo.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.UserEntity;

public class UserWithoutGames {
  private Long id;
  private String email;
  private Date dateCreated;
  private List<Sessions> sessions;

  public static UserWithoutGames toModel(UserEntity entity) {
    UserWithoutGames model = new UserWithoutGames();
    model.setId(entity.getId());
    model.setEmail(entity.getEmail());
    model.setDateCreated(entity.getDateCreated());
    model.setSessions(entity.getSessions().stream().map(Sessions::toModel).collect(Collectors.toList()));
    return model;
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

  public List<Sessions> getSessions() {
    return sessions;
  }

  public void setId(Long id) {
     this.id = id;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public void setSessions(List<Sessions> sessions) {
    this.sessions = sessions;
  }

}
