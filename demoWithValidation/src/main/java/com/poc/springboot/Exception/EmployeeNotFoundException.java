package com.poc.springboot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	private String id;

	private String msg;

	public EmployeeNotFoundException(String id, String msg) {
		super(String.format(" not found : '%s'", id));
		this.id = id;
		this.msg = msg;

	}

	public String getId() {
		return this.id;
	}

	public String getMsg() {
		return this.msg;
	}

}
