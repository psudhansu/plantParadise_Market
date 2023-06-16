package com.plantparadisemarket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plantparadisemarket.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	public Optional<Admin> findByUsername(String username);
	
	
}
