package com.cunningstunts.abstemious.shared.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
  @Id Long id;
  Date dateCreated;
  Date dateLastModified;
  String name;
}
