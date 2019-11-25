package com.poc.springboot.model;

public class SalaryBreakUpModel {

	

	private double grossSalary;

	private double basic;

	private double hra;

	private double cityCompAllow;

	private double conveyance;
	
	private double medical;
	private double education;
	private double lta;

	public double getMedical() {
		return medical;
	}

	public void setMedical(double medical) {
		this.medical = medical;
	}

	public double getEducation() {
		return education;
	}

	public void setEducation(double education) {
		this.education = education;
	}

	public double getLta() {
		return lta;
	}

	public void setLta(double lta) {
		this.lta = lta;
	}


	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getCityCompAllow() {
		return cityCompAllow;
	}

	public void setCityCompAllow(double cityCompAllow) {
		this.cityCompAllow = cityCompAllow;
	}

	public double getConveyance() {
		return conveyance;
	}

	public void setConveyance(double conveyance) {
		this.conveyance = conveyance;
	}
	

}
