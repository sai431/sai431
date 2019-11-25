package com.poc.springboot.Exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionCustom {
	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public List<String>
	 * handleValidationExceptions(MethodArgumentNotValidException ex) { return
	 * ex.getBindingResult() .getAllErrors().stream()
	 * .map(ObjectError::getDefaultMessage) .collect(Collectors.toList()); }
	 */
}
