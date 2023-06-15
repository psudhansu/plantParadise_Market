package com.plantparadisemarket.service;

import java.util.List;
import java.util.Optional;

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
		if(customer==null || customer.getCustomerEmail()==null)throw new CustomerException("Customer Cannot be null.");
		Optional<Customer> cust=customerRepo.findByCustomerEmail(customer.getCustomerEmail());
		if(cust.isPresent()) {
			throw new CustomerException("Customer with this email "+customer.getCustomerEmail()+" already exist.");
		}
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		System.out.println(customer);
		if(customer==null || customer.getCustomerEmail()==null)throw new CustomerException("Customer Cannot be null.");
		Optional<Customer> cust=customerRepo.findByCustomerEmail(customer.getCustomerEmail());
		if(cust.isEmpty()) {
			throw new CustomerException("Customer with email "+customer.getCustomerEmail()+" does not exist.");
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
	public List<Customer> viewAllCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public boolean validateCustomer(String userName, String password) {
		Optional<Customer> res=customerRepo.findByCustomerEmailAndPassword(userName, password);
		return res.isPresent();
	}
	
	
	
}
