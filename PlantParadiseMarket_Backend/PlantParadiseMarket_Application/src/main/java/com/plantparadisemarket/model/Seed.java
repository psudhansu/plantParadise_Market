package com.plantparadisemarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Seed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JsonProperty(access = Access.READ_ONLY)
	private Integer seedId;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(unique=true)
	private String commonName;
	
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String bloomTime;
	
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String watering;
	
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String typeOfSeeds;
	
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 10)
	private String seedsDescription;
	
	
	@NotNull	
	private double seedsCost;
	
	@NotNull	
	private Integer seedsPerPacket;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Planter planter;
	
}
