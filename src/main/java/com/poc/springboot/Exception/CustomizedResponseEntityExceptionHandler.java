package com.poc.springboot.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	/*
	 * @ExceptionHandler(StudentNotFoundException) public final
	 * ResponseEntity<ErrorDetails>
	 * handleUserNotFoundException(StudentNotFoundException ex, WebRequest request)
	 * { ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	 * request.getDescription(false)); return new ResponseEntity<>(errorDetails,
	 * HttpStatus.NOT_FOUND); }
	 */

}
