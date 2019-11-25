package com.poc.springboot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//I have added the @ResponseStatus(HttpStatus.NOT_FOUND) annotation to the above exception class to tell Spring Boot to respond with a 404 status when this exception is thrown.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends RuntimeException{
	
	 public RoleNotFoundException() {
	        super();
	    }
	 
	 public RoleNotFoundException(String message) {
	        super(message);
	    }
	 
	 public RoleNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }

}
