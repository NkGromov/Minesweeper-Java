package com.example.demo.repository;

import com.example.demo.entity.GamesEntity;

import org.springframework.data.repository.CrudRepository;

public interface GamesRepo extends CrudRepository<GamesEntity, Long> {
  
}
