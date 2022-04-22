package com.example.demo.model;


import com.example.demo.entity.GamesEntity;
import com.example.demo.entity.SapperSchemesEntity;

public class GamesWithoutPlayers {
  private Long id;
  private Boolean isWin;
  private SapperSchemesEntity sapperSchemes;

  public static GamesWithoutPlayers toModel(GamesEntity entity) {
    GamesWithoutPlayers model = new GamesWithoutPlayers();
    model.setId(entity.getId());
    model.setIsWin(entity.getIsWin());
    model.setSapperSchemes(entity.getSapperSchemes());
    return model;
  }
  
  public Long getId() {
    return id;
  }

  public Boolean getIsWin() {
    return isWin;
  }


  public SapperSchemesEntity getSapperSchemes() {
    return sapperSchemes;
  }

  public void setId(Long id) {
     this.id = id;
  }

  public void setIsWin(Boolean isWin) {
    this.isWin = isWin;
  }

  public void setSapperSchemes(SapperSchemesEntity sapperSchemes) {
    this.sapperSchemes = sapperSchemes;
  }

}
