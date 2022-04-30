package com.example.demo.service;

import com.example.demo.entity.GameTemplatesEntity;
import com.example.demo.repository.GameTemplatesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameTemplatesService {
  @Autowired private GameTemplatesRepo gameTemplatesRepo;
  
  public GameTemplatesEntity[] getTemplate (Long modeId) {
      return gameTemplatesRepo.findAllByGameModeId(modeId);
  }

  public GameTemplatesEntity setTemplate (GameTemplatesEntity template) {
    return gameTemplatesRepo.save(template);
  }
}
