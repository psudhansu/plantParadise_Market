package com.plantparadisemarket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.plantparadisemarket.model.Admin;
import com.plantparadisemarket.model.Customer;
import com.plantparadisemarket.repository.AdminRepository;
import com.plantparadisemarket.repository.CustomerRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
  
	@Autowired
	private CustomerRepository cusRepo;
	
	@Autowired
	private AdminRepository adRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Customer> optc = cusRepo.findByUsername(username);
		
		Optional<Admin> opta = adRepo.findByUsername(username);
		if(optc.isPresent() && opta.isEmpty()) {
			Customer cus = optc.get();
			List<GrantedAuthority> authorities= new ArrayList<>();
			SimpleGrantedAuthority sga= new SimpleGrantedAuthority(cus.getRole());
			authorities.add(sga);
			return new User(cus.getUsername(),cus.getPassword(),authorities);
		}else if(opta.isPresent() && optc.isEmpty()) {
			Admin ad = opta.get();
			List<GrantedAuthority> authorities= new ArrayList<>();
			SimpleGrantedAuthority sga= new SimpleGrantedAuthority(ad.getRole());
			authorities.add(sga);
			return new User(ad.getUsername(),ad.getPassword(),authorities);
		}else
			throw new BadCredentialsException("User Details not found with this username: "+username);
		
	}

}
