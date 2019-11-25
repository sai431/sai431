package com.poc.springboot.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {

	private Long empId;

	@NotNull
	@Size(min = 2, message = "empName should have atleast 2 characters")
	private String empName;
	@NotNull(message = "Please provide empRole")
	private String role;
	@NotNull(message = "Please provide a ctc salary")
	private Long salaryCtc;

	public Long getSalaryCtc() {
		return salaryCtc;
	}

	public void setSalaryCtc(Long salaryCtc) {
		this.salaryCtc = salaryCtc;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
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
