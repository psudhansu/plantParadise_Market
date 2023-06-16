package com.plantparadisemarket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.plantparadisemarket.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>,PagingAndSortingRepository<Customer, Integer>{

	public Optional<Customer> findByCustomerEmail(String email);
	
	public Optional<Customer> findByCustomerEmailAndPassword(String customerEmail,String password); 
	
	public Optional<Customer> findByusername(String username);
	public Optional<Customer> findByPhoneNo(String phoneNo);

	
}
