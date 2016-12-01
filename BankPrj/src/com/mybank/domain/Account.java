package com.mybank.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Account {
    protected double iBalance;
    
    public double getBalance() {
        return iBalance;
    }
    
    public void deposit(double amt) {
    	iBalance = iBalance + amt;
    }
    
    public void withdraw(double amt) throws OverdraftException {
        if (iBalance >= amt) {
        	iBalance = iBalance - amt;
        }
        else{
        	throw new OverdraftException("Insufficient funds", amt - iBalance);
        }
     }

    protected Account(double aBalance) {
    	iBalance = aBalance;
    }

    public int hashCode(){
    	return HashCodeBuilder.reflectionHashCode(this);
    }
    
	public boolean equals(Object arg0) {
		return EqualsBuilder.reflectionEquals(this,arg0);
	}

}
