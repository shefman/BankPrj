package com.mybank.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.mybank.domain.Customer;

public class DeSerializeCustomer {
	private File dataFile;
	
	
	public DeSerializeCustomer(String dataFilePath) throws IOException, ClassNotFoundException{
		Customer customer = null; 
		dataFile = new File(dataFilePath);
		dataFile.createNewFile();
		FileInputStream f = new FileInputStream(dataFile);
		ObjectInputStream s = new ObjectInputStream(f);
		customer = (Customer) s.readObject();
		System.out.println("Customer get from " + dataFile);
		System.out.println(customer.getFirstName()+" "+customer.getLastName());
		s.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		new DeSerializeCustomer(args[0]);

	}

}
