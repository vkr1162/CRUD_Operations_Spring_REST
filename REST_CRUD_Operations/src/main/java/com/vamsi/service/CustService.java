package com.vamsi.service;


import java.util.List;

import com.vamsi.entity.Customer;

public interface CustService {

	public String registerCustomer(Customer cust);
	
	public Customer getCustomerById(Integer id);
	
	public List<Customer> getAllCustomerByAddress(String city);
	
	public String updateCustomer(Customer cust);
	
	public String modifyPrice(Integer id, double price);
	
	public Object deleteCustomerById(Integer id);
	
}
