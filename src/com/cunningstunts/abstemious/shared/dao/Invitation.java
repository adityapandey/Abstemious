package com.cunningstunts.abstemious.shared.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.googlecode.objectify.Key;

@Entity
public class Invitation implements Serializable {
  @Id
  String token;
  Key<User> userId;
  String email;
}
