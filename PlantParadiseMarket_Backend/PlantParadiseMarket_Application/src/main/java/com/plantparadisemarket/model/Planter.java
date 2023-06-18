package com.plantparadisemarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JsonProperty(access = Access.READ_ONLY)
	private int planterId;
	
	@NotNull
	@Min(value =1, message =  "Minimum height should be 1 feet")
	private Float planterHeight;
	
	@NotNull
	private Integer planterCapacity;
	
	@NotNull
	private Integer drinageHole;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String planterColor;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String planterShape;
	
	@NotNull
	private Integer planterStock;
	
	@NotNull
	private Integer planterCost;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Orders orders;
	
	@OneToOne(mappedBy = "planter",cascade = CascadeType.ALL)
	@JsonIgnore
	private Plant plant;
	
	@OneToOne(mappedBy = "planter",cascade = CascadeType.ALL)
	@JsonIgnore
	private Seed seed;
	
	

	public int getPlanterId() {
		return planterId;
	}

	public void setPlanterId(int planterId) {
		this.planterId = planterId;
	}

	public Float getPlanterHeight() {
		return planterHeight;
	}

	public void setPlanterHeight(Float planterHeight) {
		this.planterHeight = planterHeight;
	}

	public Integer getPlanterCapacity() {
		return planterCapacity;
	}

	public void setPlanterCapacity(Integer planterCapacity) {
		this.planterCapacity = planterCapacity;
	}

	public Integer getDrinageHole() {
		return drinageHole;
	}

	public void setDrinageHole(Integer drinageHole) {
		this.drinageHole = drinageHole;
	}

	public String getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}

	public String getPlanterShape() {
		return planterShape;
	}

	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}

	public Integer getPlanterStock() {
		return planterStock;
	}

	public void setPlanterStock(Integer planterStock) {
		this.planterStock = planterStock;
	}

	public Integer getPlanterCost() {
		return planterCost;
	}

	public void setPlanterCost(Integer planterCost) {
		this.planterCost = planterCost;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public Seed getSeed() {
		return seed;
	}

	public void setSeed(Seed seed) {
		this.seed = seed;
	}
	
}
