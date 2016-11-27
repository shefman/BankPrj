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
	
	public boolean withdraw(double amt){
		boolean result = true;
		if (iBalance < amt){
			double overdraftNeeded = amt - iBalance;
			if (overdraftAmount < overdraftNeeded){
				result = false;
			}
			else{
				iBalance = 0.0;
				overdraftAmount -= overdraftNeeded;
			}
		}
		else{
			iBalance -= amt;
		}
		return result;
	}

}
