package com.tutorial.library.exception;

public class EntityNotFoundException extends RuntimeException{
	public EntityNotFoundException(Long id) {
		super("Could not found exception"+ id);
	}
}