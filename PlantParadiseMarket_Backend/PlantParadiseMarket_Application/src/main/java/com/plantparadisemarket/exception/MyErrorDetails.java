package com.plantparadisemarket.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetails {
  private LocalDate timeStamp;
  private String Details;
  private String message;
public LocalDate getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(LocalDate timeStamp) {
	this.timeStamp = timeStamp;
}
public String getDetails() {
	return Details;
}
public void setDetails(String details) {
	Details = details;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
  
  
}
