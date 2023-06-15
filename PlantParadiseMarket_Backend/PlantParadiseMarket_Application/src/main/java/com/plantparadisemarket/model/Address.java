package com.plantparadisemarket.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
//	private Integer addressId;
	@NotNull
	@NotEmpty
	@NotBlank
	private String houseNo;
	@NotNull
	@NotEmpty
	@NotBlank
	private String colony;
	@NotNull
	@NotEmpty
	@NotBlank
	private String city;
	@NotNull
	@NotEmpty
	@NotBlank
	private String state;
	@NotNull
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "^\\d{6}$")
	private String pincode;
	
}
