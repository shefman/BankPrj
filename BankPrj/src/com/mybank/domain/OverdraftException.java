package com.mybank.domain;

public class OverdraftException extends Exception {
	
	private double deficit;
	
	public OverdraftException(String msg, double gDeficit){
		super(msg);
		deficit = gDeficit;
	}
	
	public double getDeficit(){
		return deficit;
	}

}
