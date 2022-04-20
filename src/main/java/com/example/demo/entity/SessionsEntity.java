package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class SessionsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;
  private Long date;

  public Long getId() {
    return id;
  }
  public UserEntity  getUserId() {
    return user;
  }

  public Long getDate() {
    return date;
  }
  
}
