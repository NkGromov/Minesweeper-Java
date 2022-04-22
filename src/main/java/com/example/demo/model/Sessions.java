package com.example.demo.model;

import java.util.Date;

import com.example.demo.entity.SessionsEntity;

public class Sessions {
  private Long id;
  private Date date;

  public static Sessions toModel(SessionsEntity entity) {
    Sessions model = new Sessions();
    model.setId(entity.getId());
    model.setDate(entity.getDate());
    return model;
  }

  public Long getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  public void setId(Long id) {
     this.id = id;
  }

  public void setDate(Date date) {
    this.date = date;
 }

}
