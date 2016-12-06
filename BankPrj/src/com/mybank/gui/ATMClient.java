package com.mybank.gui;

import com.mybank.data.*;

import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	  enterButton = new JButton("Enter");
	  
	  keyPadPanel = new JPanel();
	  actionButtonPanel = new JPanel();
	  generalPanel = new JPanel();
}
  
  private void addKeyPadButton(String numberStr){
      JButton button = new JButton(numberStr);
      keyPadPanel.add(button);
      ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dataEntry.setText(dataEntry.getText()+numberStr);
		}
	};
      button.addActionListener(listener);
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
		keyPadPanel.add(new JButton("."));
		keyPadPanel.add(enterButton);

		
//		frame.add(keyPadPanel,BorderLayout.CENTER);
		
		generalPanel.setLayout(new GridLayout(2, 1));
		generalPanel.add(actionButtonPanel);
		generalPanel.add(keyPadPanel);
		frame.add(generalPanel, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
		
		actionButtonPanel.disable();
		output.append("Enter ID and press Enter");
		
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
