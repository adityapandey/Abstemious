package com.cunningstunts.abstemious.server.login;

import com.cunningstunts.abstemious.shared.login.LoginInfo;
import com.cunningstunts.abstemious.shared.login.LoginService;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
  private UserService userService = UserServiceFactory.getUserService();

  @Override
  public LoginInfo getLoginInfo(String loginRedirectUrl) {
    User user = userService.getCurrentUser();
    LoginInfo loginInfo = new LoginInfo();
    if (user != null) {
      loginInfo.setLoggedIn(true);
      loginInfo.setLogoutUrl(userService.createLogoutURL(loginRedirectUrl));
      loginInfo.setUserId(user.getUserId());
      loginInfo.setUserName(user.getNickname());
    } else {
      loginInfo.setLoggedIn(false);
      loginInfo.setLoginUrl(userService.createLoginURL(loginRedirectUrl));
    }
    return loginInfo;
  }
}
