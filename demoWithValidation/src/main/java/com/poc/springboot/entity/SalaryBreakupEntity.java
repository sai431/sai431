package com.poc.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TBL_SALARY_INFO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SalaryBreakupEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long salId;

	@Column
	private double grossSalary;

	@Column
	private double basic;

	@Column
	private double hra;
	@Column
	private double cityCompAllow;
	@Column
	private double conveyance;

	@Column
	private double education;
	@Column
	private double medical;
	@Column
	private double lta;

	public double getLta() {
		return lta;
	}

	public void setLta(double lta) {
		this.lta = lta;
	}

	@OneToOne(fetch = FetchType.LAZY)
	private EmpSalaryBrkUpEntity empsalbrk;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employeeinfoEntity_empId", nullable = false, updatable = true)
	@JsonIgnore
	private EmpLoyeeInfoEntity empLoyeeInfoEntity;

	public Long getSalId() {
		return salId;
	}

	public void setSalId(Long salId) {
		this.salId = salId;
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

	public double getEducation() {
		return education;
	}

	public void setEducation(double education) {
		this.education = education;
	}

	public double getMedical() {
		return medical;
	}

	public void setMedical(double medical) {
		this.medical = medical;
	}

	public EmpSalaryBrkUpEntity getEmpsalbrk() {
		return empsalbrk;
	}

	public void setEmpsalbrk(EmpSalaryBrkUpEntity empsalbrk) {
		this.empsalbrk = empsalbrk;
	}

	public EmpLoyeeInfoEntity getEmpLoyeeInfoEntity() {
		return empLoyeeInfoEntity;
	}

	public void setEmpLoyeeInfoEntity(EmpLoyeeInfoEntity empLoyeeInfoEntity) {
		this.empLoyeeInfoEntity = empLoyeeInfoEntity;
	}

}
