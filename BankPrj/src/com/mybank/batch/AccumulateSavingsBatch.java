package com.mybank.batch;

import com.mybank.domain.*;


public class AccumulateSavingsBatch {
	
	private Bank bank;
	
	public void setBank(Bank gBank){
		bank = gBank;
	}
	
	public void doBatch(){
		for (int custInd=0 ; custInd < bank.getNumOfCustomers() ; custInd++){
			Customer customer = bank.getCustomer(custInd);
			for (int accInd=0 ; accInd < customer.getNumOfAccounts() ; accInd++){
				Account account = customer.getAccount(accInd);
				if (account instanceof SavingsAccount){
					((SavingsAccount) account).accumulateInterest();
				}
			}
		}
	}	                     

}
