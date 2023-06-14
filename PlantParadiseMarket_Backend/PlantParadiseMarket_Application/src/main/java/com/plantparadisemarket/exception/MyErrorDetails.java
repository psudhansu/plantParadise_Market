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
}
