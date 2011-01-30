package com.cunningstunts.abstemious.client;

import com.cunningstunts.abstemious.client.presenter.LoginStatusPresenter;
import com.cunningstunts.abstemious.client.presenter.Presenter;
import com.cunningstunts.abstemious.client.view.LoginStatusView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class Application implements Presenter, ValueChangeHandler<String> {
  private HasWidgets container;
  private LoginStatusView loginStatusView;
  private EventBus eventBus;

  public Application(EventBus eventBus) {
    this.eventBus = eventBus;
    bindHandlers();
  }

  private void bindHandlers() {
    History.addValueChangeHandler(this);
    // Additional eventBus bindings will go here.
  }

  @Override
  public void go(HasWidgets container) {
    this.container = container;

    if ("".equals(History.getToken())) {
      History.newItem("loggedout");
    } else {
      History.fireCurrentHistoryState();
    }
  }

  // Gets called each time there is a history change.
  // Depending on token, we create and assign the appropriate presenter to its view and then
  // call Presenter.go(this.container).
  @Override
  public void onValueChange(ValueChangeEvent<String> event) {
    GWT.log("onValueChanged " + event.toDebugString());
    String token = event.getValue();
    if (token != null) {
      // Do something with history token
      if (token.equals("loggedout")) {
        GWT.runAsync(new RunAsyncCallback() {

          @Override
          public void onSuccess() {
            if (loginStatusView == null) {
              loginStatusView = new LoginStatusView();
            }
            LoginStatusPresenter loginStatusPresenter = new LoginStatusPresenter(loginStatusView);
            loginStatusPresenter.go(container);
          }

          @Override
          public void onFailure(Throwable reason) {
            GWT.log("token loggedout", reason);
          }
        });
      }
    } else {
      GWT.log("null token in Apllication.onValueChanged");
    }
  }
}
