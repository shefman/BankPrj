package com.mybank.domain;

public class Customer {
	
	private Account[] accounts;
	private int numberOfAccounts;
    private String firstName;
    private String lastName;
    
    public Customer(String f, String l) {
    	firstName = f;
    	lastName = l;
    	accounts = new Account[15];
    	numberOfAccounts = 0;
    }

    public String getFirstName(){
    	return firstName;
    }

    public String getLastName(){
    	return lastName;
    }
    
    public Account getAccount(int index){
    	return accounts[index];
    }

    public void addAccount(Account newAccount){
    	accounts[numberOfAccounts] = newAccount;
    	numberOfAccounts++;    	
    }
    
    public int getNumOfAccounts(){
    	return numberOfAccounts;
    }
}
