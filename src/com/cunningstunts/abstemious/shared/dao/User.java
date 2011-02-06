package com.cunningstunts.abstemious.shared.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User implements Serializable {
  @Id Long id;
  Date dateCreated;
  Date dateLastModified;
  String name;
  List<Long> groupIds;
  String googleId;
  
  // We don't store the groupId->balance map in datastore.
  @Transient Map<Long, Long> balances;

  /** Default constructor required by Objectify. */
  public User() {
  }
  
  public User(String name) {
	  this.name = name;
	  Date date = new Date();
	  dateCreated = date;
	  dateLastModified = date;
  }
  
  public String toString() {
	  return "Person [Name: " + name + ", id:" + id + ", dateCreated:" + dateCreated +
	  		", dateLastModified:" + dateLastModified + "]";
	}
}
