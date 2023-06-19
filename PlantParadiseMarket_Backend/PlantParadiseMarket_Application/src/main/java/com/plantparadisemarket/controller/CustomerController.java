package com.plantparadisemarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plantparadisemarket.model.Customer;
import com.plantparadisemarket.service.CustomerServiceImpl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ppm")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@PostMapping("/registerCustomers")
	public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer customer){
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    	customer.setRole("ROLE_USER");
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer){
		
		return new ResponseEntity<>(customerService.updateCustomer(customer),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{custId}")
	public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable("custId") Integer customerId){
		
		return new ResponseEntity<>(customerService.deleteCustomer(customerId),HttpStatus.GONE);
	}
	
	@GetMapping("/customer/{custId}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable("custId") Integer customerId){
		
		return new ResponseEntity<>(customerService.viewCustomer(customerId),HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomersHandler(){
		
		return new ResponseEntity<>(customerService.viewAllCustomer(),HttpStatus.OK);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<Customer> getCustomerByEmailHandler(@RequestParam("username") String username){
		
		return new ResponseEntity<>(customerService.viewCustomerByUsername(username),HttpStatus.OK);
	}
	
	@GetMapping("/customerByNumber/{number}")
	public ResponseEntity<Customer> getCustomerByPhoneNoHandler(@PathVariable String number){
		
		return new ResponseEntity<>(customerService.viewCustomerByPhoneNo(number),HttpStatus.OK);
	}
	
//	@GetMapping("/validate")
//	public ResponseEntity<Boolean> validateCustomerHandler(@RequestParam("username") String username,@RequestParam("password") String password){
//		System.out.println("hello here");
//		return new ResponseEntity<>(customerService.validateCustomer(username, password),HttpStatus.OK);
//	}
	
	 @GetMapping("/CustomerSignIn")
	    public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
	    System.out.println(auth); // this Authentication object having Principle object details
	    Customer customer= customerService.viewCustomerByUsername(auth.getName());
	    customer.setSessionId(customerService.authenticate());
	    return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	  }
	 
	
	 @PostMapping("/logout")
	    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
	        // Invalidate the current user's session
	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }

	        // Clear the authentication
	        SecurityContextHolder.clearContext();

	        // Remove the JSESSIONID cookie
	        Cookie cookie = new Cookie("JSESSIONID", null);
	        cookie.setPath("/");
	        cookie.setMaxAge(0);
	        response.addCookie(cookie);

	        return ResponseEntity.ok("Logout successful");
	    }
}
