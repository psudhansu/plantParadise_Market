package com.plantparadisemarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantparadisemarket.exception.AdminException;
import com.plantparadisemarket.model.Admin;
import com.plantparadisemarket.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public Admin registerAdmin(Admin admin) {
		if(admin==null || admin.getUsername()==null)throw new AdminException("Admin cannot be null");
		Optional<Admin> adminOpt=adminRepo.findByUsername(admin.getUsername());
		if(adminOpt.isPresent()) {
			throw new AdminException("Admin already exist.");
		}
		return adminRepo.save(admin);
	}

	@Override
	public Admin deleteAdmin(Integer adminId) {
		if(adminId==null || adminId==0)throw new AdminException("Invalid adminId");
		Admin resAdmin=adminRepo.findById(adminId).orElseThrow(()->new AdminException("Admin with Id "+adminId+" does not exist"));
		adminRepo.delete(resAdmin);
		return resAdmin;
	}

	@Override
	public Admin updateAdminPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin viewAdminByUserName(String userName) {
		if(userName==null)throw new AdminException("Invalid Username");
		Admin resAdmin=adminRepo.findByUsername(userName).orElseThrow(()-> new AdminException("Admin with Username "+userName+" does not exist"));
		return resAdmin;
	}

	@Override
	public List<Admin> viewAllAdmin() {
		List<Admin> resList=adminRepo.findAll();
		if(resList.isEmpty()) {
			throw new AdminException("No admin present");
		}
		return resList;
	}

	@Override
	public Admin getAdminById(Integer adminId) {
		if(adminId==null || adminId==0)throw new AdminException("Invalid adminId");
		Admin resAdmin=adminRepo.findById(adminId).orElseThrow(()->new AdminException("Admin with Id "+adminId+" does not exist"));
		
		return resAdmin;
		
	}

}
