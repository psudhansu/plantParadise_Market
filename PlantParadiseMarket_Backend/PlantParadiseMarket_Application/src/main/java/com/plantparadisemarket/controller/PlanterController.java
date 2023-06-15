package com.plantparadisemarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plantparadisemarket.model.Plant;
import com.plantparadisemarket.model.Planter;
import com.plantparadisemarket.service.PlanterServiceImpl;

import jakarta.validation.Valid;

@RestController
public class PlanterController {

	@Autowired 
	private PlanterServiceImpl Planterservice;
	
	@PostMapping("/planters")
	public ResponseEntity<Planter> savePlanterHandller(@Valid @RequestBody Planter planter) {
		
		Planter planter1 = Planterservice.addPlanter(planter);
		
		return new ResponseEntity<>(planter1, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/UpdatePlanter")
	public ResponseEntity<Planter> updatePlanterHandller(@Valid @RequestBody Planter planter) {
		
		Planter planter1 = Planterservice.updatePlanter(planter);
		
		return new ResponseEntity<>(planter1, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/DeletePlanter/{planterid}")
	public ResponseEntity<Planter> DeletePlanterHandller(@PathVariable("planterid") Integer PlanterId) {
		
		Planter planter1 = Planterservice.deletePlanter(PlanterId);
		
		return new ResponseEntity<>(planter1, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/ViewPlanter/{planterId}")
	public ResponseEntity<Planter> viewPlanterHandller(@PathVariable("planterId") Integer PlanterId) {
		
		Planter planter1 = Planterservice.viewPlanter(PlanterId);
		
		return new ResponseEntity<>(planter1, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/ViewPlanterByShape/{Plantershape}")
	public ResponseEntity<Planter> viewPlanterByShapeHandller(@PathVariable("Plantershape") String plantershape) {
		
		Planter planter = Planterservice.viewPlanterByPlanterShape(plantershape);
		
		return new ResponseEntity<>(planter, HttpStatus.ACCEPTED);
	}

	@GetMapping("/plantViewType/{mincost}/{maxcost}")
	public ResponseEntity<List<Planter>> viewPlanterByCostPlantHandller(@PathVariable("mincost") double minCost,@PathVariable("maxcost") double maxCost) {
		
		List<Planter> planters = Planterservice.viewAllPlanters(minCost, maxCost);
		
		return new ResponseEntity<>(planters, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/ViewAllPlanters")
	public ResponseEntity<List<Planter>> viewAllPlantHandller() {
		
		List<Planter> planters = Planterservice.viewAllPlanters();
		
		return new ResponseEntity<>(planters, HttpStatus.ACCEPTED);
	}
}
