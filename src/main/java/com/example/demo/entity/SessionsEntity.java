package com.example.demo.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class SessionsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;
  private Date date;

  public Long getId() {
    return id;
  }
  public UserEntity  getUserId() {
    return user;
  }

  public Date getDate() {
    return date;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
