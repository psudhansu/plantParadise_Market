package com.plantparadisemarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Planter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planterId;
	
	@NotNull
	private Float planterHeight;
	
	@NotNull
	private Integer planterCapacity;
	
	
	
}
