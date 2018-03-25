package com.jerseyweb.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.jerseyweb.model.Customer;

public class CustomersServiceImpl {
	
	List<Customer> list =new ArrayList<>();
	
	public List<Customer> gecust(){
		Customer customer =new Customer();
		customer.setId(1);
		customer.setName("Manoj");;
		customer.setEmail("manoj@gmail.com");
		
		Customer customer2 =new Customer();
		customer2.setId(1);
		customer2.setName("tanoj");;
		customer2.setEmail("tanoj@gmail.com");
		list.add(customer);
		list.add(customer2);
		
		return list;
		
	}

}
