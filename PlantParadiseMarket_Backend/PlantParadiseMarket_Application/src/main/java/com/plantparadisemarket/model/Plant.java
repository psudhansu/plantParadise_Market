package com.plantparadisemarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer plantId;

	@NotNull
	private Integer plantHeight;
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String commonName;

	@NotNull
	@NotBlank
	@NotEmpty
	private String bloomTime;

	@NotNull
	@NotBlank
	@NotEmpty
	private String medicinalOrCulinaryUse;

	@NotNull
	@NotBlank
	@NotEmpty
	private String temperature;

	@NotNull
	@NotBlank
	@NotEmpty
	private String typeOfPlant;

	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 10)
	private String plantDescription;
	
	@NotNull
	private double plantCost;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Orders orders;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Planter planter;
	
}
