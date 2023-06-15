package com.plantparadisemarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantparadisemarket.exception.PlantException;
import com.plantparadisemarket.model.Plant;
import com.plantparadisemarket.repository.PlantRepository;

@Service
public class PlantServiceImpl implements PlantService{

	@Autowired
	private PlantRepository plantRepository;

//	add plants _----------------------------------------------------------------------------------------------
	
	@Override
	public Plant addPlant(Plant plant) throws PlantException {
		
		if(plant==null) throw new PlantException("Plants Detailes is Not Valid !!");
		
		Optional<Plant> newPlan= plantRepository.findById(plant.getPlantId());
		
		if(newPlan.isPresent()) throw new PlantException("This Plant is Already Existed !");
		
		return plantRepository.save(plant);
	}


//	Update plants _----------------------------------------------------------------------------------------------
	
	
	@Override
	public Plant updatePlant(Plant plant) throws PlantException {
		if(plant==null) throw new PlantException("Plants Detailes is Not Valid !!");
		
		Optional<Plant> newPlan= plantRepository.findById(plant.getPlantId());
		
		if(!newPlan.isPresent()) throw new PlantException("This Plant is Not Existed !");
		
		return plantRepository.save(plant);
	}


//	Update plants _----------------------------------------------------------------------------------------------
	
	
	@Override
	public Plant deletePlantById(Integer plantId) throws PlantException {
		if(plantId==null) throw new PlantException("Plants Detailes is Not Valid !!");
		
		Optional<Plant> newPlan= plantRepository.findById(plantId);
		
		if(!newPlan.isPresent()) throw new PlantException("This Plant is Not Existed !");
		
		Plant plant1= newPlan.get();
		
		plantRepository.delete(plant1);
		
		return plant1;
		
	}

	@Override
	public Plant viewPlant(Integer plantId) throws PlantException {
		if(plantId==null) throw new PlantException("Plants Detailes is Not Valid !!");
		
		Optional<Plant> newPlant= plantRepository.findById(plantId);
		
		if(!newPlant.isPresent()) throw new PlantException("This Plant is Not Existed !");
		
		Plant plant1= newPlant.get();
		
		return plant1;
	}

	@Override
	public List<Plant> viewPlantByCommonName(String commonName) throws PlantException {
		if(commonName==null) throw new PlantException("Plants Detailes is Not Valid !!");
		
		List<Plant> plantList= plantRepository.findByCommonName(commonName);
		
		if(plantList.isEmpty()) throw new PlantException("List is empty");
		
		return plantList;
		
	}

	@Override
	public List<Plant> viewPlants() throws PlantException {
		List<Plant> plantList= plantRepository.findAll();
		
		if(plantList.isEmpty()) throw new PlantException("List is empty");
		return plantList;
	}

	@Override
	public List<Plant> viewAllPlantsByType(String typeOfPlant) throws PlantException {
		if(typeOfPlant==null) throw new PlantException("Plants Detailes is Not Valid !!");
		
		List<Plant> plantList= plantRepository.findByTypeOfPlant(typeOfPlant);
		
		if(plantList.isEmpty()) throw new PlantException("List is empty");
		
		return plantList;
	}
	
}
