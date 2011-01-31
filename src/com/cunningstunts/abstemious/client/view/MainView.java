package com.cunningstunts.abstemious.client.view;

import com.cunningstunts.abstemious.client.presenter.MainPresenter;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.SimplePanel;

public class MainView extends Composite implements MainPresenter.UI {
  private SimplePanel lenderViewPanel;

  public MainView() {
    lenderViewPanel = new SimplePanel();
    initWidget(lenderViewPanel);
  }

  @Override
  public HasWidgets getBorrowerViewContainer() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HasWidgets getLenderViewContainer() {
    return lenderViewPanel;
  }

  @Override
  public HasWidgets getSharedBillViewContainer() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HasWidgets getUserProfileContainer() {
    // TODO Auto-generated method stub
    return null;
  }

}
