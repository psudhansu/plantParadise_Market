package com.plantparadisemarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.plantparadisemarket.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>,PagingAndSortingRepository<Customer, Integer>{
	
	public List<Plant> findByCommonName(String commonName);

	public List<Plant> findByTypeOfPlant(String commonName);
	
}
