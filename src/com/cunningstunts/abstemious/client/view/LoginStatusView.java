package com.cunningstunts.abstemious.client.view;

import com.cunningstunts.abstemious.client.presenter.LoginStatusPresenter;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class LoginStatusView extends Composite implements LoginStatusPresenter.UI {
  private Label userLabel = new Label();
  private Anchor loginLink = new Anchor();

  public LoginStatusView() {
    FlowPanel panel = new FlowPanel();
    initWidget(panel);
    panel.add(userLabel);
    panel.add(loginLink);
    userLabel.setVisible(false);
  }

  @Override
  public void clearUserName() {
    userLabel.setVisible(false);
  }

  @Override
  public void setUserName(String userName) {
    userLabel.setText(userName);
    userLabel.setVisible(true);
  }

  @Override
  public void setLoginLink(String text, String url) {
    loginLink.setText(text);
    loginLink.setHref(url);
  }
}
