package com.poc.springbbot.constants;

import java.util.Date;

public class ErrorDetailsValidation {
	private Date timestamp;
	private String message;
	private String details;
	
	public ErrorDetailsValidation(Date  timestamp, String  message,  String details) {
	    super();
	    this.timestamp = timestamp;
	    this.message = message;
	    this.details = details;
	  }

}
