package com.vamsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vamsi.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query("From Customer where cAddress=:city")
	public List<Customer> findByCAddress(String city);
}
