package com.poc.springboot.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


//I have added the @ResponseStatus(HttpStatus.NOT_FOUND) annotation to the above exception class to tell Spring Boot to respond with a 404 status when this exception is thrown.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	 public ResourceNotFoundException() {
	        super();
	    }
	 
	 public ResourceNotFoundException(String message) {
	        super(message);
	    }
	 
	 public ResourceNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
