package com.wellsfargo.SBA3.its.controller;

import org.springframework.http.HttpStatus

;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wellsfargo.SBA3.its.exceptions.UserException;



@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<String> handleItsException(UserException exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}