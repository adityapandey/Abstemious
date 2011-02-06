package com.cunningstunts.abstemious.client.event;

import com.cunningstunts.abstemious.shared.login.LoginInfo;
import com.google.gwt.event.shared.GwtEvent;

public class LoginEvent extends GwtEvent<LoginEventHandler>{
  public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();

  private LoginInfo loginInfo;

  @Override
  protected void dispatch(LoginEventHandler handler) {
    handler.onLoginEvent(this);
  }

  @Override
  public com.google.gwt.event.shared.GwtEvent.Type<LoginEventHandler> getAssociatedType() {
    return TYPE;
  }

  public void setLoginInfo(LoginInfo loginInfo) {
    this.loginInfo = loginInfo;
  }

  public LoginInfo getLoginInfo() {
    return loginInfo;
  }

  public boolean isLoggedIn() {
    return loginInfo.isLoggedIn();
  }

}
