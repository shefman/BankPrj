package com.mybank.test;

import java.util.*;
import com.mybank.domain.*;

public class TestCovariance {
	
	public static void printNames(List <? extends Account> lea) {
		for (int i=0; i < lea.size(); i++) {
		System.out.println(lea.get(i).getBalance());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Customer> ca1 = new HashSet<Customer>();
		ca1.add(new Customer("Jane", "Simms"));
		ca1.add(new Customer("Jane2", "Simms2"));
		ArrayList<Customer> ar1 = new ArrayList<Customer>();
		ar1.add(new Customer("Jane", "Simms"));
		if (ar1.contains(new Customer("Jane", "Simms"))){
			System.out.println("+");
		}
		
		
		
		List<CheckingAccount> lc = new ArrayList<CheckingAccount>();
		List<SavingsAccount> ls = new ArrayList<SavingsAccount>();
		
		printNames(lc);
		printNames(ls);
		
		//but...
		List<CheckingAccount> leo = lc; //OK
		leo.add(new CheckingAccount(100));//Compile error!
		
		printNames(leo);

	}

}
