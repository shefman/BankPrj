package com.mybank.domain;

public class Customer {
	
    private String firstName;
    private String lastName;
    private Account iAccount;
    
    public Customer(String f, String l) {
    	firstName = f;
    	lastName = l;
    }

    public String getFirstName(){
    	return firstName;
    }

    public String getLastName(){
    	return lastName;
    }
    
    public Account getAccount(){
    	return iAccount;
    }

    public void setAccount(Account acct){
    	iAccount = acct;
    } 
}
