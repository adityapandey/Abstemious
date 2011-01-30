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
}
