package com.plantparadisemarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantparadisemarket.model.Admin;
import com.plantparadisemarket.model.Customer;
import com.plantparadisemarket.service.AdminServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aam")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<Admin> registerAdminHandler(@Valid @RequestBody Admin admin){
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		admin.setRole("ROLE_ADMIN");
		return new ResponseEntity<>(adminService.registerAdmin(admin),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<Admin> deleteAdminHandler(@PathVariable Integer adminId){
		
		return new ResponseEntity<>(adminService.deleteAdmin(adminId),HttpStatus.GONE);
	}
	
	@GetMapping("/getAdmin/{username}")
	public ResponseEntity<Admin> viewAdminByUsernameHandler(@PathVariable String username){
		
		return new ResponseEntity<>(adminService.viewAdminByUserName(username),HttpStatus.OK);
	}
	
	@GetMapping("/getAdmins")
	public ResponseEntity<List<Admin>> viewAllAdminHandler(){
		
		return new ResponseEntity<>(adminService.viewAllAdmin(),HttpStatus.OK);
	}
	@GetMapping("/AdminSignIn")
    public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){
    System.out.println(auth); // this Authentication object having Principle object details
    Admin admin= adminService.viewAdminByUserName(auth.getName());
    return new ResponseEntity<>(admin.getAdminName()+" Logged In Successfully", HttpStatus.ACCEPTED);
    }
	
}
