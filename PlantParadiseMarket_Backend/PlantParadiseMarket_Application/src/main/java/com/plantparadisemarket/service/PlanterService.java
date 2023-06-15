package com.plantparadisemarket.service;

import java.util.List;

import com.plantparadisemarket.exception.PlanterException;
import com.plantparadisemarket.model.Plant;
import com.plantparadisemarket.model.Planter;

public interface PlanterService {
	public Planter addPlanter(Planter planter) throws PlanterException;
	public Planter updatePlanter(Planter planter) throws PlanterException;
	public Planter deletePlanter(Integer planterid) throws PlanterException;
	public Planter viewPlanter(Integer planterId) throws PlanterException;
	public Planter viewPlanterByPlanterShape(String commonName) throws PlanterException;
	public List<Planter> viewAllPlanters() throws PlanterException;
	
	public List<Planter> viewAllPlanters(double minCost,double maxCost) throws PlanterException;
}
