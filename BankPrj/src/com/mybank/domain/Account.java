package com.mybank.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Account {
    protected double iBalance;
    
    public double getBalance() {
        return iBalance;
    }
    
    public boolean deposit(double amt) {
    	iBalance = iBalance + amt;
    	return true;
    }
    
    public boolean withdraw(double amt) {
        if (iBalance >= amt) {
        	iBalance = iBalance - amt;
        	return true;
        }
        else{
        	return false;
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
