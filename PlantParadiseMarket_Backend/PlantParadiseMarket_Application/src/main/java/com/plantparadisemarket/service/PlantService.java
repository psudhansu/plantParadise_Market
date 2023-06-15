package com.plantparadisemarket.service;

import java.util.List;

import com.plantparadisemarket.exception.PlantException;
import com.plantparadisemarket.model.Plant;

public interface PlantService {

	public Plant addPlant(Plant plant) throws PlantException;
	public Plant updatePlant(Plant plant) throws PlantException;
	public Plant deletePlantById(Integer plantId) throws PlantException;
	public Plant viewPlant(Integer plantId) throws PlantException;
	public List<Plant> viewPlantByCommonName(String commonName) throws PlantException;
	public List<Plant> viewPlants() throws PlantException;
	
	public List<Plant> viewAllPlantsByType(String typeOfPlant) throws PlantException;
	
	
}
