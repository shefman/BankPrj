package com.mybank.domain;

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

}
