package com.cunningstunts.abstemious.client.view;

import com.cunningstunts.abstemious.client.presenter.TwoPartyTransactionPresenter.UI;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class TwoPartyTransactionView extends Composite implements UI {
  private HorizontalPanel mainPanel = new HorizontalPanel();
  private Image oneInsideCircle = new Image("images/one.png");
  private Label lenderOrBorrowerLabel = new Label();
  private Label amountLabel = new Label("Amount:");
  private TextBox otherUser = new TextBox();
  private TextBox amount = new TextBox();
  private Button submitButton = new Button("Submit");
  private Button cancelButton = new Button("Cancel");


  public TwoPartyTransactionView() {
    initWidget(mainPanel);
    mainPanel.add(oneInsideCircle);
    Grid gridPanel = new Grid(3, 2);
    gridPanel.setWidget(0, 0, lenderOrBorrowerLabel);
    gridPanel.setWidget(0, 1, otherUser);
    gridPanel.setWidget(1, 0, amountLabel);
    gridPanel.setWidget(1, 1, amount);
    Grid buttonPanel = new Grid(1, 2);
    buttonPanel.setWidget(0, 0, submitButton);
    buttonPanel.setWidget(0, 1, cancelButton);
    gridPanel.setWidget(2, 1, buttonPanel);
    mainPanel.add(gridPanel);
  }

  @Override
  public String getAmount() {
    return amount.getText();
  }

  @Override
  public String getOtherUser() {
    return otherUser.getText();
  }

  @Override
  public HasClickHandlers getCancelButton() {
    return cancelButton;
  }

  @Override
  public HasClickHandlers getSubmitButton() {
    return submitButton;
  }

  @Override
  public void setLenderOrBorrowerLabelText(String labelText) {
    lenderOrBorrowerLabel.setText(labelText);
  }

}
