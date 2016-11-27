package com.mybank.domain;

public class SavingsAccount extends Account {

	private double interestRate;
	
	public void accumulateInterest(){
		iBalance = iBalance + (iBalance*(interestRate/12));
	}
	
	public SavingsAccount(double initBalance, double aInterestRate) {
		super(initBalance);
		this.interestRate = aInterestRate;
	}

}
