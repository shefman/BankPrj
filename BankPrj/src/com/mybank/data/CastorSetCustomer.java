package com.mybank.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.mybank.domain.Customer;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;

public class CastorSetCustomer {
	
	private File dataFile;

	public CastorSetCustomer(String dataFilePath) throws IOException, MarshalException, ValidationException{
		Customer customer = new Customer("Vas", "pup");
		
		dataFile = new File(dataFilePath);

		FileWriter writer = new FileWriter(dataFile);
		Marshaller.marshal(customer, writer);
		
		System.out.println("Customer marhelled " + dataFile);
				
	}

	public static void main(String[] args) throws MarshalException, ValidationException, IOException {
		// TODO Auto-generated method stub
		new CastorSetCustomer(args[0]);		
	}

}
