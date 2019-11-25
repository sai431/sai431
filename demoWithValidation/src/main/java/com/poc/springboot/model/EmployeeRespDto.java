package com.poc.springboot.model;

import com.poc.springbbot.constants.ErrorDetails;
import com.poc.springboot.Exception.EmployeeNotFoundException;

public class EmployeeRespDto {
	private EmployeeConversionModel employee;

	//private SalaryBreakUpModel salbrkup;

	public EmployeeRespDto() {

	}

	public EmployeeRespDto(EmployeeNotFoundException exception) {

	}

	/*
	 * public SalaryBreakUpModel getSalbrkup() { return salbrkup; }
	 * 
	 * public void setSalbrkup(SalaryBreakUpModel salbrkup) { this.salbrkup =
	 * salbrkup; }
	 */

	public EmployeeRespDto(ErrorDetails errorDetails) {
		super();
	}

	public EmployeeConversionModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeConversionModel employee) {
		this.employee = employee;
	}

}
