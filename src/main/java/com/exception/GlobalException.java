package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.entity.RoleDetails;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(RoleAlreadyExist.class)
	public ResponseEntity<String> RoleAlreadyExist(Exception ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
@ExceptionHandler(RoleNotfounException.class)
	public ResponseEntity<String> RoleNotfound(Exception ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	
	
	public ResponseEntity handledRuntime(RuntimeException rex) {
		return new ResponseEntity(rex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
