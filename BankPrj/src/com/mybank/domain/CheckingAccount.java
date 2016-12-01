package com.mybank.domain;

public class CheckingAccount extends Account{

	private double overdraftAmount;
	
	public CheckingAccount(double initBalance, double gOverdraft){
		super(initBalance);
		this.overdraftAmount = gOverdraft;		
	}

	public CheckingAccount(double initBalance){
		this(initBalance, 0.0);		
	}
	
	public void withdraw(double amt) throws OverdraftException{
        if (iBalance >= amt) {
        	iBalance -= amt;
        }
        else{
        	double overdraftNeeded = amt - iBalance;
			if (overdraftAmount >= overdraftNeeded){
				iBalance = 0.0;
				overdraftAmount -= overdraftNeeded;
			}
			else{
	        	throw new OverdraftException("Insufficient funds for overdraft protection", overdraftNeeded);
			}
        }
	}

}
