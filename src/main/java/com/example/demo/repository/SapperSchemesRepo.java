package com.example.demo.repository;

import com.example.demo.entity.SapperSchemesEntity;

import org.springframework.data.repository.CrudRepository;

public interface SapperSchemesRepo extends CrudRepository<SapperSchemesEntity, Long> {
  
}
