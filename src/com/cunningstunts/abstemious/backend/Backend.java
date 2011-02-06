package com.cunningstunts.abstemious.backend;

import com.cunningstunts.abstemious.shared.dao.User;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class Backend {
  static {
    ObjectifyService.register(User.class);
  }
  
  private Objectify ofy;
  
  public Backend() {
    ofy = ObjectifyService.begin();
  }
  
  /** Adds a user to the datastore. */
  public void addUser(User user) {
    ofy.put(user);
  }
  
  /** Retrieves user from datastore. */
  public User getUser(long id) {
    return ofy.get(User.class, id);
  }

}
