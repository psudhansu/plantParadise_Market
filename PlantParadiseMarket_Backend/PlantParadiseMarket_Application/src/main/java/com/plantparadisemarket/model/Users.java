package com.plantparadisemarket.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
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
	@Email(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",message = "Invalid username Id, you can use you email as your username")
	@Column(unique = true)	
   private String username;
	
	@NotBlank
	@NotEmpty
	@NotNull
	//@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])[a-zA-Z\\d@#$%^&+=]{6,15}$",message = "Invalid Password, your password should contain atleast one number, one special character, one capital letter and rest can be small letters")
   private String password;
	
   private String role;
	
   @JsonProperty(access = Access.READ_ONLY)
   private String sessionId;
	
}
