package com.mybank.data;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;

public class DataSource {

	private File dataFile;
	
	public DataSource(String dataFilePath){
		dataFile = new File(dataFilePath);				
	}
	
	public void loadData() throws IOException{
		Scanner input = new Scanner(dataFile);
		
		Customer customer;
		int numOfCustomers = input.nextInt();
		
		for (int indCust=0 ; indCust < numOfCustomers ; indCust++){
			String intFirstName = input.next();
			String intSecondName = input.next();
			Bank.addCustomer(intFirstName, intSecondName);
			customer = Bank.getCustomer(indCust);
			int numOfAccount = input.nextInt();
			for (int indAcc=0 ; indAcc < numOfAccount ; indAcc++){
				char accountType = input.next().charAt(0);
				switch (accountType) {
				case 'S':
					double fBalanceS = input.nextDouble();
					double fInterestRate = input.nextDouble();
					SavingsAccount sAccount = new SavingsAccount(fBalanceS, fInterestRate);
					customer.addAccount(sAccount);					
					break;
				case 'C':
					double fBalanceC = input.nextDouble();
					double foverdraftAmount = input.nextDouble();
					CheckingAccount cAccount = new CheckingAccount(fBalanceC, foverdraftAmount);
					customer.addAccount(cAccount);
					break;

				default:
					System.out.println("not existing account tipe");
				}			
			}
		}
		input.close();		
	}
	
}
