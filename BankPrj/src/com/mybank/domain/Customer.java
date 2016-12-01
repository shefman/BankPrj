package com.mybank.domain;

import java.util.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
    
    public boolean equals(Object arg0){
    	return EqualsBuilder.reflectionEquals(this,arg0);
    }
    
    public int hashCode(){
    	return HashCodeBuilder.reflectionHashCode(this);
    }

}
