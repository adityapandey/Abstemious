package com.cunningstunts.abstemious.shared.login;

import com.google.gwt.user.client.rpc.RemoteService;

public interface LoginService extends RemoteService {
  public LoginInfo getLoginInfo(String loginRedirectUrl);
}
