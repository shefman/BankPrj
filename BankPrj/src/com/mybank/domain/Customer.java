package com.mybank.domain;

import java.util.*;

public class Customer {
	
	private List<Account> accounts;
    private String firstName;
    private String lastName;
    
    public Customer(String f, String l) {
    	firstName = f;
    	lastName = l;
    	accounts = new ArrayList<Account>();
    }

    public String getFirstName(){
    	return firstName;
    }

    public String getLastName(){
    	return lastName;
    }
    
    public Account getAccount(int gIndex){
    	return accounts.get(gIndex);
    }

    public void addAccount(Account newAccount){
    	accounts.add(newAccount);
    }
    
    public int getNumOfAccounts(){
    	return accounts.size();
    }
}
