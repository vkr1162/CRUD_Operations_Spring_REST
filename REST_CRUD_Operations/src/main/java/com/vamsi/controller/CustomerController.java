package com.vamsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamsi.entity.Customer;
import com.vamsi.service.CustService;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {

	@Autowired
	private CustService custService;
	
	@PostMapping("/register")
	private ResponseEntity<?> registerCustomer(@RequestBody Customer cust){
		//System.out.println(cust.toString());
		
		try {
			String msg = custService.registerCustomer(cust);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getCustomer/{id}")
	private ResponseEntity<?> getCustomerById(@PathVariable Integer id){
		try {
			Customer cust = custService.getCustomerById(id);
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getCustomerByCity/{cAddress}")
	private ResponseEntity<?> getCustomerByAddress(@PathVariable(name="cAddress") String city){
		System.out.println(city);
		try {
			List<Customer> custList = custService.getAllCustomerByAddress(city);
			return new ResponseEntity<List<Customer>>(custList,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/modify")
	private ResponseEntity<?> updateCustomer(@RequestBody Customer cust){
		try {
			String msg = custService.updateCustomer(cust);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/updatePrice/{id}/{price}")
	private ResponseEntity<String> modifyCustPrice(@PathVariable Integer id, @PathVariable Double price){
		try {
			String msg = custService.modifyPrice(id, price);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<?> deleteCustomerById(@PathVariable Integer id){
		try {
			Object obj = custService.deleteCustomerById(id);
			return new ResponseEntity<Object>(obj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
