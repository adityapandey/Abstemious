package com.cunningstunts.abstemious.shared.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expense implements Serializable {
  @Id Long id;
  Date timestamp;
  Date lastModified;

  public Expense() {
    timestamp = lastModified = new Date();
  }
}
