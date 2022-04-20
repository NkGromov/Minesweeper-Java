package com.example.demo.repository;

import com.example.demo.entity.ModesEntity;

import org.springframework.data.repository.CrudRepository;

public interface ModesRepo extends CrudRepository<ModesEntity, Long> {
  
}
