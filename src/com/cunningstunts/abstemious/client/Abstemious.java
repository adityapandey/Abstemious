package com.cunningstunts.abstemious.client;

import com.cunningstunts.abstemious.client.presenter.LoginStatusPresenter;
import com.cunningstunts.abstemious.client.view.LoginStatusView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;

public class Abstemious implements EntryPoint {

  public void onModuleLoad() {
    EventBus eventBus = new SimpleEventBus();
    Application application = new Application(eventBus);
    LoginStatusPresenter loginStatusPresenter =
        new LoginStatusPresenter(new LoginStatusView(), eventBus);
    loginStatusPresenter.go(RootPanel.get("loginbox"));
    application.go(RootPanel.get("abstemiousframe"));
  }
}
