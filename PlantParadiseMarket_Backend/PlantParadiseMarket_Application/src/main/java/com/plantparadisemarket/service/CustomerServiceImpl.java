package com.plantparadisemarket.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantparadisemarket.exception.CustomerException;
import com.plantparadisemarket.model.Customer;
import com.plantparadisemarket.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		if(customer==null || customer.getUsername()==null)throw new CustomerException("Customer Cannot be null.");
		Optional<Customer> cust=customerRepo.findByUsername(customer.getUsername());
		if(cust.isPresent()) {
			throw new CustomerException("Customer with this Username "+customer.getUsername()+" already exist.");
		}
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		System.out.println(customer);
		if(customer==null || customer.getUsername()==null)throw new CustomerException("Customer Cannot be null.");
		Optional<Customer> cust=customerRepo.findByUsername(customer.getUsername());
		if(cust.isEmpty()) {
			throw new CustomerException("Customer with Username "+customer.getUsername()+" does not exist.");
		}
		Customer res=cust.get();
		res.setAddress(customer.getAddress());
		res.setCustomerName(customer.getCustomerName());
		res.setPassword(customer.getPassword());
		res.setPhoneNo(customer.getPhoneNo());
		return customerRepo.save(res);
	}

	@Override
	public Customer deleteCustomer(Integer customerId) {
		if(customerId==null || customerId==0)throw new CustomerException("Invalid CustomerId");
		Customer cust=customerRepo.findById(customerId).orElseThrow(()-> new CustomerException("Customer with CustomerId "+customerId+" does not exist"));
		customerRepo.delete(cust);
		return cust;
	}

	@Override
	public Customer viewCustomer(Integer customerId) {
		if(customerId==null || customerId==0)throw new CustomerException("Invalid CustomerId");
		Customer cust=customerRepo.findById(customerId).orElseThrow(()-> new CustomerException("Customer with CustomerId "+customerId+" does not exist"));
		return cust;
	}
	
	@Override
	public Customer viewCustomerByUsername(String username) {
		if(username==null)throw new CustomerException("Email cannot be null");
		Customer cust=customerRepo.findByUsername(username).orElseThrow(()-> new CustomerException("Customer with email "+username+" does not exist"));
		return cust;
	}
	
	@Override
	public Customer viewCustomerByPhoneNo(String phoneNo) {
		
		if(phoneNo==null)throw new CustomerException("Phone Number Cannot be null");
		Pattern p=Pattern.compile("^[6-9]\\d{9}$");
		Matcher m=p.matcher(phoneNo);
		if(!m.matches()) {
		   throw new CustomerException("Invalid Phone Number");
		}
		
		Customer cust=customerRepo.findByPhoneNo(phoneNo).orElseThrow(()-> new CustomerException("Customer with Phone Number "+phoneNo+" does not exist"));
		return cust;
		
	}

	@Override
	public List<Customer> viewAllCustomer() {
		return customerRepo.findAll();
	}

//	@Override
//	public boolean validateCustomer(String userName, String password) {
//		Optional<Customer> res=customerRepo.findByCustomerEmailAndPassword(userName, password);
//		return res.isPresent();
//	}
	
	
	
}
