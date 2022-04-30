package com.example.demo.entity;
import javax.persistence.*;


@Entity
public class GameTemplatesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @ManyToOne
  private ModesEntity gameMode;
  private int[] size;
  
  public GameTemplatesEntity(){}
  
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int[] getSize() {
    return size;
  }
}
