package com.cunningstunts.abstemious.client;

import com.cunningstunts.abstemious.client.event.AddExpenseEvent;
import com.cunningstunts.abstemious.client.event.AddExpenseEventHandler;
import com.cunningstunts.abstemious.client.event.LoginEvent;
import com.cunningstunts.abstemious.client.event.LoginEventHandler;
import com.cunningstunts.abstemious.client.presenter.LoggedOutPresenter;
import com.cunningstunts.abstemious.client.presenter.MainPresenter;
import com.cunningstunts.abstemious.client.presenter.Presenter;
import com.cunningstunts.abstemious.client.view.LoggedOutView;
import com.cunningstunts.abstemious.client.view.MainView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class Application implements Presenter, ValueChangeHandler<String> {
  private HasWidgets container;
  private EventBus eventBus;

  public Application(EventBus eventBus) {
    this.eventBus = eventBus;
    bind();
  }

  private void bind() {
    History.addValueChangeHandler(this);
    // Additional eventBus bindings go here.
    eventBus.addHandler(AddExpenseEvent.TYPE, new AddExpenseEventHandler() {
      @Override
      public void onAddExpense(AddExpenseEvent addExpenseEvent) {
        GWT.log("AddExpenseEvent: " + addExpenseEvent.toDebugString());
      }
    });
    eventBus.addHandler(LoginEvent.TYPE, new LoginEventHandler() {
      @Override
      public void onLoginEvent(LoginEvent event) {
        if (event.isLoggedIn()) {
          History.newItem("landing");
        } else {
          History.newItem("loggedout");
        }
      }
    });
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
      navigateTo(token);
    } else {
      GWT.log("null token in Apllication.onValueChanged");
    }
  }

  private void navigateTo(String token) {
    if (token.equals("loggedout")) {
      // User is logged out.
      GWT.runAsync(new RunAsyncCallback() {
        @Override
        public void onSuccess() {
          new LoggedOutPresenter(new LoggedOutView(), eventBus).go(container);
        }
        @Override
        public void onFailure(Throwable reason) {
          GWT.log("token loggedout", reason);
        }
      });
    } else if (token.equals("landing")) {
      // Landing page.
      GWT.runAsync(new RunAsyncCallback() {
        @Override
        public void onSuccess() {
          new MainPresenter(new MainView(), eventBus).go(container);
        }
        @Override
        public void onFailure(Throwable reason) {
          GWT.log("token landing", reason);
        }
      });
    }
  }
}
