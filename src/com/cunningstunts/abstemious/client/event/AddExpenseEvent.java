package com.cunningstunts.abstemious.client.event;

import java.util.ArrayList;

import com.cunningstunts.abstemious.shared.dao.Expense;
import com.cunningstunts.abstemious.shared.dao.Transaction;
import com.google.gwt.event.shared.GwtEvent;

public class AddExpenseEvent extends GwtEvent<AddExpenseEventHandler>{
  public static Type<AddExpenseEventHandler> TYPE = new Type<AddExpenseEventHandler>();
  private Expense expense;
  private ArrayList<Transaction> transactions;

  @Override
  protected void dispatch(AddExpenseEventHandler handler) {
    handler.onAddExpense(this);
  }

  @Override
  public com.google.gwt.event.shared.GwtEvent.Type<AddExpenseEventHandler> getAssociatedType() {
    return TYPE;
  }

  public Expense getExpense() {
    return expense;
  }

  public void setExpense(Expense expense) {
    this.expense = expense;
  }

  public ArrayList<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(ArrayList<Transaction> transactions) {
    this.transactions = transactions;
  }

}
