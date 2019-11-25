package com.poc.springboot.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	/*
	 * @ExceptionHandler(ConstraintViolationException.class) public final
	 * ResponseEntity<ErrorResponse> handleConstraintViolation(
	 * ConstraintViolationException ex, WebRequest request) { List<String> details =
	 * ex.getConstraintViolations() .parallelStream() .map(e -> e.getMessage())
	 * .collect(Collectors.toList());
	 * 
	 * ErrorResponse error = new ErrorResponse(BAD_REQUEST, details); return new
	 * ResponseEntity<>(error, HttpStatus.BAD_REQUEST); }
	 */
	 
	/*
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) { ErrorDetails errorDetails =
	 * new ErrorDetails((java.sql.Date) new Date(), "Validation Failed",
	 * ex.getBindingResult().toString()); return new ResponseEntity(errorDetails,
	 * HttpStatus.BAD_REQUEST); }
	 */
	
	/*
	 * @ExceptionHandler(StudentNotFoundException) public final
	 * ResponseEntity<ErrorDetails>
	 * handleUserNotFoundException(StudentNotFoundException ex, WebRequest request)
	 * { ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	 * request.getDescription(false)); return new ResponseEntity<>(errorDetails,
	 * HttpStatus.NOT_FOUND); }
	 */
	

}
