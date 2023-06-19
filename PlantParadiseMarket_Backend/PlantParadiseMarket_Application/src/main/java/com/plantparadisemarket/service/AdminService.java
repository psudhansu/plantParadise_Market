package com.plantparadisemarket.service;

import java.util.List;

import com.plantparadisemarket.model.Admin;

public interface AdminService {

	public Admin registerAdmin(Admin admin);
	public Admin deleteAdmin(Integer adminId);
	public Admin updateAdminPassword(String password);
	public Admin viewAdminByUserName(String username);

	public List<Admin> viewAllAdmin();
	public Admin getAdminById(Integer adminId);
	
}
