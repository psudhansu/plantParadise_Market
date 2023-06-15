package com.plantparadisemarket.service;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantparadisemarket.exception.PlanterException;
import com.plantparadisemarket.model.Planter;
import com.plantparadisemarket.repository.PlanterRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlanterServiceImpl implements PlanterService{
	Logger log=LoggerFactory.getLogger(PlanterService.class);
	
	@Autowired
	private PlanterRepository planterrepository;
	
	 public Planter addPlanter(Planter planter) {
	    	log.info("Planter added successfully");
	    	
	    	if(planter == null) throw new PlanterException("Planter is null") ; 
	    	
	    	Optional<Planter> plntr = planterrepository.findById(planter.getPlanterId()) ;
	    	
	    	if(plntr.isPresent()) throw new PlanterException("already present in database") ;
	    	
	    	return planterrepository.save(planter) ;
	       
	    }

	@Override
	public Planter updatePlanter(Planter planter) throws PlanterException {
     if(planter==null) throw new PlanterException("Planter Details are not valid !!");
		
		Optional<Planter> newPlanter= planterrepository.findById(planter.getPlanterId());
		
		if(!newPlanter.isPresent()) throw new PlanterException("This Planter is not existed !");
		
		log.info("Planter updated successfully");
		
		return planterrepository.save(planter);
		
	}

	@Override
	public Planter viewPlanter(Integer planterId) throws PlanterException {
    if(planterId==null) throw new PlanterException("Planter Details are not valid !!");
		
		Optional<Planter> newPlanter= planterrepository.findById(planterId);
		
		if(!newPlanter.isPresent()) throw new PlanterException("This Planter is not existed !");
		
		Planter planter= newPlanter.get();
		
		log.info("Planter found successfully");
		
		return planter;
	}

	@Override
	public Planter deletePlanter(Integer planterid) throws PlanterException {	
		
    if(planterid==null) throw new PlanterException("Planter Details are not valid !!");
		
		Optional<Planter> newPlanter= planterrepository.findById(planterid);
		
		if(!newPlanter.isPresent()) throw new PlanterException("This Planter is not existed !");
		
		Planter planter1= newPlanter.get();
		
		planterrepository.delete(planter1);
		
		return planter1;
	}

	@Override
	public Planter viewPlanterByPlanterShape(String PlanterShape) throws PlanterException {
		
       if(PlanterShape==null) throw new PlanterException("Planter Details are not valid !!");
		
		Planter planter= planterrepository.findByPlanterShape(PlanterShape);
		
		if(planter==null) throw new PlanterException("planter not found");
		
		log.info("Planter details viewed successfully");
		
		return planter;
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		
    List<Planter> planterList= planterrepository.findAll();
		
		if(planterList.isEmpty()) throw new PlanterException("List is empty");
		
		log.info("Planter details viewed successfully");
		
		return planterList;
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) throws PlanterException {
		
		if(minCost>maxCost)throw new PlanterException("Planter Details are not valid !!");
		
		 List<Planter> planterList= planterrepository.findByPlanterCostBetween(minCost, maxCost);
		 
		 if(planterList.isEmpty()) throw new PlanterException("List is empty");
			
		 log.info("Planter details viewed successfully");
		 
			return planterList;
		 
	}



}
