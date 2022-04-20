package com.example.demo.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class ModesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @OneToMany(mappedBy = "mode")
  private List<GamesEntity> games;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
