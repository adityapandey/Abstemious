package com.cunningstunts.abstemious.client.presenter;

import com.cunningstunts.abstemious.client.event.LoginEvent;
import com.cunningstunts.abstemious.client.event.LoginEventHandler;
import com.cunningstunts.abstemious.client.util.LoggingHelper;
import com.cunningstunts.abstemious.shared.login.LoginInfo;
import com.cunningstunts.abstemious.shared.login.LoginService;
import com.cunningstunts.abstemious.shared.login.LoginServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class LoginStatusPresenter implements Presenter {
  private static final String REDIRECT_URL =
      "http://127.0.0.1:8888/Abstemious.html?gwt.codesvr=127.0.0.1:9997";

  public interface UI {
    Widget asWidget();
    void setUserName(String userName);
    void setLoginLink(String text, String url);
    void clearUserName();
  }

  private final UI ui;
  private final EventBus eventBus;
  private final LoginServiceAsync loginService = GWT.create(LoginService.class);

  public LoginStatusPresenter(UI ui, EventBus eventBus) {
    this.ui = ui;
    this.eventBus = eventBus;
    ((ServiceDefTarget)loginService).setServiceEntryPoint("/login");
    bind();
  }

  private void bind() {
    eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
      @Override
      public void onLoginEvent(LoginEvent event) {
        LoggingHelper.log("Login event");
        if (event.isLoggedIn()) {
          ui.setUserName(event.getLoginInfo().getUserName());
          ui.setLoginLink("Logout", event.getLoginInfo().getLogoutUrl());
        } else {
          ui.clearUserName();
          ui.setLoginLink("Login", event.getLoginInfo().getLoginUrl());
        }
      }
    });
  }

  @Override
  public void go(HasWidgets container) {
    container.clear();
    container.add(ui.asWidget());
    tryToLogin();
  }

  private void tryToLogin() {
    LoggingHelper.log("Trying to get login information");
    loginService.getLoginInfo(REDIRECT_URL, new AsyncCallback<LoginInfo>() {
      @Override
      public void onSuccess(LoginInfo result) {
        LoggingHelper.log("Got logininfo for: " + result.getUserId());
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setLoginInfo(result);
        eventBus.fireEventFromSource(loginEvent, this);
      }
      @Override
      public void onFailure(Throwable caught) {
        LoggingHelper.log("LoginService.getLoginInfo", caught);
      }
    });
  }
}
