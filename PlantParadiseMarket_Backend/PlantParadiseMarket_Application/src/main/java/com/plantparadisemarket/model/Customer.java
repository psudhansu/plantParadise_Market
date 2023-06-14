package com.plantparadisemarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.READ_ONLY)
	private int customerId;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3)
	private String customerName;
	
	@Email
	@NotNull
	private String customerEmail;
	
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3)
	private String userName;
	
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\\\S+$).{5,}$")
	private String password;
	
	
	
}
