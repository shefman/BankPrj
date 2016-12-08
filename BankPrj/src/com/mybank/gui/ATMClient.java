package com.mybank.gui;

import com.mybank.data.*;
import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.Customer;
import com.mybank.domain.OverdraftException;

import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ATMClient {

  private static final String USAGE
    = "USAGE: java com.mybank.gui.ATMClient <dataFilePath>";
  
  private JTextArea output;
  private JTextField message;
  private JTextField dataEntry;
  
  private JButton displayButton;
  private JButton depositButton;
  private JButton withdrawButton;
  
  private JPanel keyPadPanel;
  private JPanel actionButtonPanel;
  private JPanel generalPanel;
  
  private JButton enterButton;
  private JButton clearButton;
   
  private Customer currentCustomer;
  private Account currentAccount;
  private boolean depositFlag = false;
  private boolean withdrawFlag = false;
  
  public ATMClient(){
	  message = new JTextField(75);
	  message.setEnabled(false);
	  
	  dataEntry = new JTextField(10);
	  dataEntry.setEnabled(false);
	  
	  output = new JTextArea(10, 75);
	  output.setEnabled(false);
	  
	  displayButton = new JButton("display");
	  depositButton = new JButton("deposit");
	  withdrawButton = new JButton("withdraw");
	  disableActionBut();
	  enterButton = new JButton("Enter");
	  clearButton = new JButton("Clear");
	  
	  keyPadPanel = new JPanel();
	  actionButtonPanel = new JPanel();
	  generalPanel = new JPanel();
}
  
  private void addKeyPadButton(final String numberStr){
      JButton button = new JButton(numberStr);
      keyPadPanel.add(button);
      ActionListener listener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dataEntry.setText(dataEntry.getText()+numberStr);
		}
	};
      button.addActionListener(listener);
  }
  
  private class EnterHandler implements ActionListener{
	  public void actionPerformed(ActionEvent e){
		  String getText = dataEntry.getText();
		  if (!getText.contentEquals("")){
			  if (depositFlag){
				  currentAccount.deposit(Double.parseDouble(getText));
				  output.replaceRange("Your deposit "+getText+" was succesful \n", 0, output.getText().length());
				  output.append("The balance is "+currentAccount.getBalance());
				  depositFlag = false;
			  }
			  else{
				  if (withdrawFlag){
					  try {
						currentAccount.withdraw(Double.parseDouble(getText));
						output.replaceRange("Your withdraw "+getText+" was succesful \n", 0, output.getText().length());
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (OverdraftException e1) {
						// TODO Auto-generated catch block
						output.replaceRange("No money no honey \n", 0, output.getText().length());
					} finally {
						  output.append("The balance is "+currentAccount.getBalance());
						  withdrawFlag = false;
					}
				  }
				  else{
					  int specID = Integer.parseInt(getText);
					  if (specID < Bank.getNumOfCustomers()){
						  currentCustomer = Bank.getCustomer(specID);
						  currentAccount = currentCustomer.getAccount(0);
						  output.replaceRange("Welcome "+ currentCustomer.getFirstName() + " "+currentCustomer.getLastName(), 0, output.getText().length());
						  enableActionBut();
					  }
					  else
					  {
						  output.replaceRange("Customer ID "+getText+" not found", 0, output.getText().length());
						  disableActionBut();
					  }
				  }
			  }
		  }
		  dataEntry.setText("");
	  }
  }
  
  private class DisplayHandler implements ActionListener{
	  public void actionPerformed(ActionEvent e){
		  if (!currentAccount.equals(null)){
			  output.replaceRange("The balance is "+currentAccount.getBalance(), 0, output.getText().length());
		  }
		  else{
			  output.replaceRange("Customer ID not determined", 0, output.getText().length());
		  }
		  withdrawFlag = false;
		  depositFlag = false;
		  dataEntry.setText("");
	  }	
  }
  
  private class DepositHandler implements ActionListener{
	  public void actionPerformed(ActionEvent e){
		  output.replaceRange("Enter the deposit and ENTER", 0, output.getText().length());
		  withdrawFlag = false;
		  depositFlag = true;
		  dataEntry.setText("");
	  }
  }
  
  private class WithdrawHandler implements ActionListener{
	  public void actionPerformed(ActionEvent e){
		  output.replaceRange("Enter the withdraw and ENTER", 0, output.getText().length());
		  withdrawFlag = true;
		  depositFlag = false;
		  dataEntry.setText("");
	  }
  }
  
  private class ClearHandler implements ActionListener{
	  public void actionPerformed(ActionEvent e){
		  dataEntry.setText("");
	  }
  }
  
  private void disableActionBut(){
	  displayButton.setEnabled(false);
	  depositButton.setEnabled(false);
	  withdrawButton.setEnabled(false);
  }
 
  private void enableActionBut(){
	  displayButton.setEnabled(true);
	  depositButton.setEnabled(true);
	  withdrawButton.setEnabled(true);
  }

  public void launchFrame(){
		JFrame frame = new JFrame("First Java Bank ATM");
		
		frame.setLayout(new BorderLayout());

		frame.add(output, BorderLayout.EAST);
		frame.add(message, BorderLayout.SOUTH);

		
		actionButtonPanel.setLayout(new GridLayout(4, 1));
		actionButtonPanel.add(displayButton);
		actionButtonPanel.add(depositButton);
		actionButtonPanel.add(withdrawButton);
		actionButtonPanel.add(dataEntry);
		
//		frame.add(actionButtonPanel,BorderLayout.CENTER);
				
		keyPadPanel.setLayout(new GridLayout(4, 3));
		for (int i = 1 ; i <= 9 ; i++){
			addKeyPadButton(String.valueOf(i));
		}
		addKeyPadButton("0");
		keyPadPanel.add(clearButton);
		keyPadPanel.add(enterButton);

		
//		frame.add(keyPadPanel,BorderLayout.CENTER);
		
		generalPanel.setLayout(new GridLayout(2, 1));
		generalPanel.add(actionButtonPanel);
		generalPanel.add(keyPadPanel);
		frame.add(generalPanel, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		output.append("Enter ID and press Enter");
		clearButton.addActionListener(new ClearHandler());
		enterButton.addActionListener(new EnterHandler());
		displayButton.addActionListener(new DisplayHandler());
		depositButton.addActionListener(new DepositHandler());
		withdrawButton.addActionListener(new WithdrawHandler());
  }
 

  public static void main(String[] args) {

    // Retrieve the dataFilePath command-line argument
    if ( args.length != 1 ) {
      System.out.println(USAGE);
    } else {
      String dataFilePath = args[0];

      try {
	System.out.println("Reading data file: " + dataFilePath);
	// Create the data source and load the Bank data
	DataSource dataSource = new DataSource(dataFilePath);
	dataSource.loadData();

	// Run the ATM GUI
	ATMClient client = new ATMClient();
	client.launchFrame();

      } catch (IOException ioe) {
	System.out.println("Could not load the data file.");
	System.out.println(ioe.getMessage());
	ioe.printStackTrace(System.err);
      }
    }
  }

  // PLACE YOUR GUI CODE HERE
}
