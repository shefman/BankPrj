package com.mybank.report;

import com.mybank.domain.*;

public class CustomerReport {

  private Bank bank;

  public CustomerReport() {
  }

  public Bank getBank() {
    return bank;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public void generateReport() {

    // Print report header
    System.out.println("\t\t\tCUSTOMERS REPORT");
    System.out.println("\t\t\t================");

    // For each customer...
    for ( int cust_idx = 0;
          cust_idx < Bank.getNumOfCustomers();
          cust_idx++ ) {
      Customer customer = Bank.getCustomer(cust_idx);

      // Print the customer's name
      System.out.println();
      System.out.println("Customer: "
                         + customer.getLastName() + ", "
                         + customer.getFirstName());

      // For each account for this customer...
      for ( int acct_idx = 0;
            acct_idx < customer.getNumOfAccounts();
            acct_idx++ ) {
        Account account = customer.getAccount(acct_idx);
        String  account_type = "";

        // Determine the account type
        /*** Use the instanceof operator to test what type of account
        **** we have and set account_type to an appropriate value, such
        **** as "Savings Account" or "Checking Account". ***/
        if(account instanceof SavingsAccount){
        	account_type = "SavingsAccount";
        }
        else{
        	if (account instanceof CheckingAccount)
        	{
        		account_type = "CheckingAccount";
        	}
        }
        		
	// YOUR CODE HERE

        // Print the current balance of the account
        System.out.println(account_type + " has " + account.getBalance());
        /*** Print out the type of account and the balance. ***/
	// YOUR CODE HERE
      }
    }
  }
}
