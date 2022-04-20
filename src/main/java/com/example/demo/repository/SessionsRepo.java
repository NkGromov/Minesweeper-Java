package com.example.demo.repository;

import com.example.demo.entity.SessionsEntity;

import org.springframework.data.repository.CrudRepository;

public interface SessionsRepo extends CrudRepository<SessionsEntity, Long> {
  
}
