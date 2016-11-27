package com.mybank.test;
import com.mybank.domain.*;

public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acct = new Account(100);
		acct.deposit(47);
		acct.withdraw(150);
		System.out.println("Final account is: " + acct.getBalance());

	}

}
