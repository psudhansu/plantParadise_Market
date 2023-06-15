package com.plantparadisemarket.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.plantparadisemarket.model.Planter;

public interface PlanterRepository extends JpaRepository<Planter,Integer>,PagingAndSortingRepository<Planter,Integer>{

	public Planter findByPlanterShape(String planterShape);
	
	public List<Planter> findByPlanterCostBetween(double minCost,double maxCost);
}
