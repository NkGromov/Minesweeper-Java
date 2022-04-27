package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class SapperSchemesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int[][] scheme;
  private int countBomb;

  public SapperSchemesEntity(){}

  public Long getId() {
    return id;
  }

  public int[][] getScheme() {
    return scheme;
  }

  public int getCountBomb() {
    return countBomb;
  }

  public void setScheme(int[][] scheme) {
    this.scheme = scheme;
  }

  public void setCountBomb(int countBomb) {
    this.countBomb = countBomb;
  }
}
