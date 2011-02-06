package com.cunningstunts.abstemious.shared.login;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
  public void getLoginInfo(String loginRedirectUrl, AsyncCallback<LoginInfo> loginInfo);
}
