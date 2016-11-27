package com.mybank.domain;

public class SavingsAccount extends Account {

	private double interestRate;
	
	public SavingsAccount(double initBalance, double aInterestRate) {
		super(initBalance);
		this.interestRate = aInterestRate;
	}

}
