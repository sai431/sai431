package com.poc.springboot.model;

public class EmployeeResponseModel {

	private Employee employee;
	private SalaryBreakUpModel salmodel;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public SalaryBreakUpModel getSalmodel() {
		return salmodel;
	}

	public void setSalmodel(SalaryBreakUpModel salmodel) {
		this.salmodel = salmodel;
	}

}
