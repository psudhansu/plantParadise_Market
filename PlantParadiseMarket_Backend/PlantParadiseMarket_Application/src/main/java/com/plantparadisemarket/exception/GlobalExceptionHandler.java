package com.plantparadisemarket.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
@ControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<MyErrorDetails> notFound(MethodArgumentNotValidException me){
	  MyErrorDetails err = new MyErrorDetails();
	  err.setTimeStamp(LocalDate.now());
	  err.setMessage(me.getMessage());
	  err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
	  return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_GATEWAY);
  }
  

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<MyErrorDetails> handleNotFoundException(NoHandlerFoundException ex,WebRequest req) {
	  MyErrorDetails err = new MyErrorDetails();
	  err.setTimeStamp(LocalDate.now());
	  err.setMessage(ex.getMessage());
	  err.setDetails(req.getDescription(false));
      return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<MyErrorDetails> notFound(Exception ex,WebRequest req){
	  MyErrorDetails err = new MyErrorDetails();
	  err.setTimeStamp(LocalDate.now());
	  err.setMessage(ex.getMessage());
	  err.setDetails(req.getDescription(false));
	  return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_GATEWAY);
  }
  
  
}
