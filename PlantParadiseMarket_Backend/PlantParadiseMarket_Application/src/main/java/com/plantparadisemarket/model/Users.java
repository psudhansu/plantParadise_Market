package com.plantparadisemarket.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Data
public abstract class Users {
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(unique = true)
   private String username;
	@NotBlank
	@NotEmpty
	@NotNull
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\\\S+$).{5,}$")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private String password;
	
	private String role;
}
