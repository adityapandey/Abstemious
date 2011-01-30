package com.cunningstunts.abstemious.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class LoginStatusPresenter implements Presenter {
  public interface UI {
    HasClickHandlers getLoginButton();
    Widget asWidget();
  }

  private final UI ui;

  public LoginStatusPresenter(UI ui) {
    this.ui = ui;
    bindHandlers();
  }

  private void bindHandlers() {
    ui.getLoginButton().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        Window.alert("clicked login");
      }
    });
  }

  @Override
  public void go(HasWidgets container) {
    container.clear();
    container.add(ui.asWidget());
  }

}
