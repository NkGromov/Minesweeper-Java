package com.example.demo.model;

import com.example.demo.entity.ModesEntity;

public class Modes {
  private Long id;
  private String name;

  public static Modes toModel(ModesEntity entity) {
    Modes model = new Modes();
    model.setId(entity.getId());
    model.setDate(entity.getName());
    return model;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(Long id) {
     this.id = id;
  }

  public void setDate(String name) {
    this.name = name;
 }
}
