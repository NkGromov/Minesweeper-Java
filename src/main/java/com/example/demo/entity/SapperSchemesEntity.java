package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class SapperSchemesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int[][] scheme;

  public SapperSchemesEntity(){}

  public Long getId() {
    return id;
  }

  public int[][] getScheme() {
    return scheme;
  }

  public void setScheme(int[][] scheme) {
    this.scheme = scheme;
  }
}
