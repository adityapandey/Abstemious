package com.cunningstunts.abstemious.client.presenter;

import com.cunningstunts.abstemious.client.view.TwoPartyTransactionView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class MainPresenter implements Presenter {

  public interface UI {
    HasWidgets getBorrowerViewContainer();
    HasWidgets getLenderViewContainer();
    HasWidgets getSharedBillViewContainer();
    HasWidgets getUserProfileContainer();
    Widget asWidget();
  }

  private UI ui;
  private EventBus eventBus;

  public MainPresenter(UI ui, EventBus eventBus) {
    this.ui = ui;
    this.eventBus = eventBus;
  }

  @Override
  public void go(HasWidgets container) {
    new TwoPartyTransactionPresenter(new TwoPartyTransactionView(), eventBus).go(ui.getLenderViewContainer());
    container.clear();
    container.add(ui.asWidget());
  }

}
