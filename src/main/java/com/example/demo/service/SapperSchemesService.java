package com.example.demo.service;

import com.example.demo.entity.SapperSchemesEntity;
import com.example.demo.repository.SapperSchemesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SapperSchemesService {
  
  @Autowired
  private SapperSchemesRepo sapperSchemesRepo;

  public SapperSchemesEntity createScheme(int width, int height){
    long countBomb = Math.round((width * height) * 0.1);
    int[][] scheme = new int[width][height];
    int bombNumber =  100;

    for(int i = 0; i < scheme.length; i++){
      int maxBombInRow = Math.round(width / 2 - 1);
      for(int j = 0; j < scheme[i].length; j++){
        if(maxBombInRow == 0 || countBomb == 0) break;
        if(Math.random() > 0.5){
          scheme[i][j] = bombNumber;
          maxBombInRow--;
          countBomb--;
        }
      }
    }

    for(int i = 0; i < scheme.length; i++){
      for(int j = 0; j < scheme[i].length; j++){
        if(scheme[i][j] != bombNumber) continue;
        int start = j == 0 ? 0 : 1;
        int end = j == scheme.length - 1 ? 0 : 1;

        for(int k = j-start; k <= j+end; k++) {
          if(i > 0 && scheme[i-1][k] != bombNumber) scheme[i-1][k]++;  
          if(i < scheme.length - 1 && scheme[i+1][k] != bombNumber) scheme[i+1][k]++;  
        }

        if(j != 0 && scheme[i][j-1] != bombNumber) scheme[i][j-1]++;  
        if(j != scheme.length - 1 && scheme[i][j+1] != bombNumber) scheme[i][j+1]++; 
      }
    }

    return sapperSchemesRepo.save(new SapperSchemesEntity(scheme));
  }

}
