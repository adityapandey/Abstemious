package com.cunningstunts.abstemious.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface AddExpenseEventHandler extends EventHandler {
  public void onAddExpense(AddExpenseEvent addExpenseEvent);

}
