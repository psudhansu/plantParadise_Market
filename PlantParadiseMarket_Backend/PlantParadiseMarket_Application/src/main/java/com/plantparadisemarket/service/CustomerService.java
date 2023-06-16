package com.plantparadisemarket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plantparadisemarket.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(Integer customerId);
	public Customer viewCustomer(Integer customerId);
	public List<Customer> viewAllCustomer();
	public boolean validateCustomer(String userName, String password);
	public Customer viewCustomerByEmail(String email);
	public Customer viewCustomerByPhoneNo(String phoneNo);
	
	
}
