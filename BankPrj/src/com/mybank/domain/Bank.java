package com.mybank.domain;

public class Bank {
	
	private static Customer[] customers;
	private static int numberOfCustomers;
	
	static {
		customers = new Customer[15];
		numberOfCustomers = 0;
	}
	
	public static void addCustomer(String f, String l){
		customers[numberOfCustomers] = new Customer(f, l);
		numberOfCustomers++;		
	}
	
	public static int getNumOfCustomers(){
		return numberOfCustomers;		
	}
	
	public static Customer getCustomer(int gIndex){
		return customers[gIndex];
	}
	
	private Bank(){
		customers = new Customer[15];
		numberOfCustomers = 0;
	}
	
}
