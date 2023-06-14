package com.plantparadisemarket.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingOrderId;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate orderDate;
	
	@NotBlank
	@NotNull
	@NotEmpty
	private String transactionMode;
	
	@NotNull
	@Min(value = 1)
	private Integer quantity;
	
	@NotNull
	private Double totalCost;

	
	
	
}
