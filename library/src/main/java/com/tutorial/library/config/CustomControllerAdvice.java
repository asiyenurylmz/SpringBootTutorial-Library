package com.tutorial.library.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tutorial.library.exception.InvalidCredentialException;

@ControllerAdvice
public class CustomControllerAdvice {
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<String> handleInvalidCredentialException(InvalidCredentialException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
