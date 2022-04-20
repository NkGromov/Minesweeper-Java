package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class SapperSchemesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long[][] scheme;

  public Long getId() {
    return id;
  }

  public Long[][] getScheme() {
    return scheme;
  }

}
