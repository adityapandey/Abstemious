package com.cunningstunts.abstemious.shared.login;

import java.io.Serializable;


public class LoginInfo implements Serializable {
  private boolean loggedIn = false;
  private String userId;
  private String userName;
  private String logoutUrl;
  private String loginUrl;

  public boolean isLoggedIn() {
    return loggedIn;
  }
  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }
  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public String getLogoutUrl() {
    return logoutUrl;
  }
  public void setLogoutUrl(String logoutUrl) {
    this.logoutUrl = logoutUrl;
  }
  public String getLoginUrl() {
    return loginUrl;
  }
  public void setLoginUrl(String loginUrl) {
    this.loginUrl = loginUrl;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getUserName() {
    return userName;
  }
}
