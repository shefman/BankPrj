package com.mybank.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.mybank.domain.Customer;

public class SerializeCustomer{
	
	private File dataFile;
	
	
	public SerializeCustomer(String dataFilePath) throws IOException{
		Customer customer = new Customer("Vas", "pup");
		dataFile = new File(dataFilePath);
		dataFile.createNewFile();
		FileOutputStream f = new FileOutputStream(dataFile);
		ObjectOutputStream s = new ObjectOutputStream(f);
		s.writeObject(customer);
		System.out.println("Customer sent to " + dataFile);
		s.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		new SerializeCustomer(args[0]);
	}

}
