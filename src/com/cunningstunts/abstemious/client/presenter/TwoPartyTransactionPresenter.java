package com.cunningstunts.abstemious.client.presenter;

import com.cunningstunts.abstemious.client.event.AddExpenseEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class TwoPartyTransactionPresenter implements Presenter {
  public interface UI {
    String getOtherUser();
    String getAmount();
    HasClickHandlers getSubmitButton();
    HasClickHandlers getCancelButton();
    void setLenderOrBorrowerLabelText(String labelText);
    Widget asWidget();
  }

  private UI ui;
  private EventBus eventBus;

  public TwoPartyTransactionPresenter(UI ui, EventBus eventBus) {
    this.ui = ui;
    this.eventBus = eventBus;
  }

  @Override
  public void go(HasWidgets container) {
    container.clear();
    container.add(ui.asWidget());
    bindEvents();
  }

  private void bindEvents() {
    ui.getSubmitButton().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        AddExpenseEvent transacationEvent = new AddExpenseEvent();
        eventBus.fireEventFromSource(transacationEvent, this);
      }
    });

    ui.getCancelButton().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        // TODO Auto-generated method stub

      }
    });
  }
}
