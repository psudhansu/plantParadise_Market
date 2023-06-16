package com.plantparadisemarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<Admin> registerAdminHandler(@Valid @RequestBody Admin admin){
		
		return new ResponseEntity<>(adminService.registerAdmin(admin),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<Admin> deleteAdminHandler(@PathVariable Integer adminId){
		
		return new ResponseEntity<>(adminService.deleteAdmin(adminId),HttpStatus.GONE);
	}
	
	@GetMapping("/getAdmin")
	public ResponseEntity<Admin> viewAdminByUsernameHandler(@PathVariable String username){
		
		return new ResponseEntity<>(adminService.viewAdminByUserName(username),HttpStatus.OK);
	}
	
	@GetMapping("/getAdmins")
	public ResponseEntity<List<Admin>> viewAllAdminHandler(){
		
		return new ResponseEntity<>(adminService.viewAllAdmin(),HttpStatus.OK);
	}
	
	
}
