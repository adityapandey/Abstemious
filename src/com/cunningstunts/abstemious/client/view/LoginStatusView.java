package com.cunningstunts.abstemious.client.view;

import com.cunningstunts.abstemious.client.presenter.LoginStatusPresenter;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class LoginStatusView extends Composite implements LoginStatusPresenter.UI {

  private final Button loginButton;

  public LoginStatusView() {
    loginButton = new Button("Login");
    initWidget(loginButton);
  }

  @Override
  public HasClickHandlers getLoginButton() {
    return loginButton;
  }

  @Override
  public Widget asWidget() {
    return this;
  }
}
