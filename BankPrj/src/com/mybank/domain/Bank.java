package com.mybank.domain;

public class Bank {
	
	private Customer[] customers;
	private int numberOfCustomers;
	
	public void addCustomer(String f, String l){
		customers[numberOfCustomers] = new Customer(f, l);
		numberOfCustomers++;		
	}
	
	public int getNumOfCustomers(){
		return numberOfCustomers;		
	}
	
	public Customer getCustomer(int gIndex){
		return customers[gIndex];
	}
	
	public Bank(){
		customers = new Customer[15];
		numberOfCustomers = 0;
	}
	
}
