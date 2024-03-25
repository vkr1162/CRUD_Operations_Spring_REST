package com.vamsi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamsi.entity.Customer;
import com.vamsi.repository.CustomerRepo;

@Service("custService")
public class CustServiceImpl implements CustService {

	@Autowired
	CustomerRepo custRepo;
	@Override
	public String registerCustomer(Customer cust) {
		
		Customer custSaved = custRepo.save(cust);
		
		return  "Customer is saved with id " + custSaved.getId(); 
	}
	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> opt = custRepo.findById(id);
			return opt.get();
		
	}
	@Override
	public List<Customer> getAllCustomerByAddress(String city) {
	List<Customer> custList = custRepo.findByCAddress(city);
		return custList;
	}
	@Override
	public String updateCustomer(Customer cust) {
		Optional<Customer> opt = custRepo.findById(cust.getId());
		if(opt.isPresent()) {
			custRepo.save(cust);
			return cust.getId() + " is Updated";
		}
		else {
		return cust.getId() + " is not found"  ;
		}
	}
	@Override
	public String modifyPrice(Integer id, double price) {
		Optional<Customer> opt = custRepo.findById(id);
		
		if(opt.isPresent()) {
			Customer cust = opt.get();
			cust.setPrice(price);
			Customer custSaved = custRepo.save(cust);
			return  "Customer with ID:" + custSaved.getId() + " Price is Updated";
		}
		else {
			return "Customer with Id: " + id + " is not found";
		}
	}
	@Override
	public Object deleteCustomerById(Integer id) {
		Optional<Customer> opt = custRepo.findById(id);
		if(opt.isPresent()) {
			 custRepo.delete(opt.get());
			 return opt.get().toString() + "is deleted";
		}
		else {
			return "Customer with Id: " + id + " is not found for deletion";
		}
	}
	@Override
	public List<Customer> getAllCustomers() {
	List<Customer> listCust = custRepo.findAll();
		return listCust;
	}

}
