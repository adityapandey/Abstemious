package com.cunningstunts.abstemious.shared.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Parent;

@Entity
public class Transaction implements Serializable {
  @Id Long id;
  @Parent Key<Expense> expenseId;
  Date timestamp;
  Key<User> userId;
  double amountPaid;
  double amountOwed;

  public Transaction() {
    timestamp = new Date();
    amountOwed = amountPaid = 0;
    userId = null;
  }

  public Transaction(Key<User> userId, double amountPaid, double amountOwed) {
    timestamp = new Date();
    this.amountOwed = amountOwed;
    this.amountPaid = amountPaid;
    this.userId = userId;
  }

  public Key<Expense> getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(Key<Expense> expenseId) {
    this.expenseId = expenseId;
  }

  public Key<User> getUserId() {
    return userId;
  }

  public void setUserId(Key<User> userId) {
    this.userId = userId;
  }

  public double getAmountPaid() {
    return amountPaid;
  }

  public void setAmountPaid(double amountPaid) {
    this.amountPaid = amountPaid;
  }

  public double getAmountOwed() {
    return amountOwed;
  }

  public void setAmountOwed(double amountOwed) {
    this.amountOwed = amountOwed;
  }

  public Long getId() {
    return id;
  }

  public Date getTimestamp() {
    return timestamp;
  }
}
