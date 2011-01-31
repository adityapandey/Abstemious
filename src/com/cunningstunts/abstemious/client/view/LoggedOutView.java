package com.cunningstunts.abstemious.client.view;

import com.cunningstunts.abstemious.client.presenter.LoggedOutPresenter;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

public class LoggedOutView extends Composite implements LoggedOutPresenter.UI {
  private Image image;

  public LoggedOutView() {
    image = new Image("http://placehold.it/800x600");
    initWidget(image);
  }
}
