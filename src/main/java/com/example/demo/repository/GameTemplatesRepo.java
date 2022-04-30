package com.example.demo.repository;

import com.example.demo.entity.GameTemplatesEntity;

import org.springframework.data.repository.CrudRepository;

public interface GameTemplatesRepo extends CrudRepository<GameTemplatesEntity, Long> {
  GameTemplatesEntity[] findAllByGameModeId(Long id);
}
