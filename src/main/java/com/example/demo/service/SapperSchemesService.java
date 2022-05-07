package com.example.demo.service;

import java.util.List;
import java.util.ArrayList;

import com.example.demo.entity.SapperSchemesEntity;
import com.example.demo.model.MinePosition;
import com.example.demo.repository.SapperSchemesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SapperSchemesService {
  
  @Autowired
  private SapperSchemesRepo sapperSchemesRepo;

  public SapperSchemesEntity createScheme(int width, int height){
    int countBombs = Math.toIntExact(Math.round((width * height) * 0.1));
    int[][] scheme = new int[height][width];
    int bombNumber =  100;
    List<MinePosition> minesPositions = this.getMines(width, height, countBombs);
    SapperSchemesEntity schemeEntity = new SapperSchemesEntity();
    for(MinePosition position : minesPositions){
      scheme[position.y][position.x] = bombNumber;
      this.setNearlyBombsCout(scheme, position.x,position.y);
    }

    schemeEntity.setCountBombs(countBombs);
    schemeEntity.setScheme(scheme);

    return sapperSchemesRepo.save(schemeEntity);
  }


  private int[][] setNearlyBombsCout(int[][] scheme, int x, int y){
    int bombNumber =  100;
    for(int rowIndex = -1; rowIndex <= 1; rowIndex++){
      for(int collIndex = -1; collIndex <= 1; collIndex++){
        int currentRowIndex = rowIndex + y;
        int currentCollIndex = collIndex + x;
        boolean minBorder = currentRowIndex >= 0 && currentCollIndex >= 0;
        boolean maxBorder = minBorder && currentRowIndex < scheme.length && currentCollIndex < scheme[currentRowIndex].length;
        if(maxBorder && minBorder && scheme[currentRowIndex][currentCollIndex] != bombNumber) scheme[currentRowIndex][currentCollIndex]++;
      }
    }
    return scheme;
  }

  private List<MinePosition> getMines(int width, int height, int countBombs){
    List<MinePosition> positions = new ArrayList<MinePosition>();
    while(positions.size() < countBombs){
      MinePosition position = new MinePosition(this.randomNumber(width), this.randomNumber(height));
      if(!positions.stream().anyMatch((el) -> this.positionMatch(position, el))) {
        positions.add(position);
      }

    }
    return positions;
  }

  private boolean positionMatch(MinePosition a, MinePosition b) {
    return a.x == b.x && a.y == b.y;
  }

  private int randomNumber(int size) {
    return Math.toIntExact(Math.round(Math.random() * (size - 1)));
  }
}
