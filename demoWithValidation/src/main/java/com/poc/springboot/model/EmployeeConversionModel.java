package com.poc.springboot.model;

public class EmployeeConversionModel {
	
	private String empName;
	private String role;
	private SalaryBreakUpModel salbrkup;
	


	public SalaryBreakUpModel getSalbrkup() {
		return salbrkup;
	}

	public void setSalbrkup(SalaryBreakUpModel salbrkup) {
		this.salbrkup = salbrkup;
	}

	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}
