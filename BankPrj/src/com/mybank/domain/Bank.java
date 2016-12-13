package com.mybank.domain;
import java.util.*;

public class Bank {
	
	private static List<Customer> customers;
	static {
		customers = new ArrayList<Customer>();
	}
	
	private static class BankHolder {  
		public static final Bank instance = new Bank();  
	}
	
	public static Bank getInstance()  {  
	     return BankHolder.instance;  
	}  
	
	public static void addCustomer(String f, String l){
		customers.add(new Customer(f, l));
	}
	
	public static int getNumOfCustomers(){
		return customers.size();		
	}
	
	public static Customer getCustomer(int gIndex){
		return customers.get(gIndex);
	}
	
	private Bank(){
		customers = new ArrayList<Customer>();
	}
	
}
