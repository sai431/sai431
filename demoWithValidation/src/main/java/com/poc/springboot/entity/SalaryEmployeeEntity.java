package com.poc.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TBL_SAL_EMPS")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class SalaryEmployeeEntity {

	@Id
	@GeneratedValue
	private Long salId;

	@Column
	private long grossSalary;

	@Column
	private long basic;

	@Column
	private long hra;
	@Column
	private long cityCompAllow;
	@Column
	private long conveyance;

	 @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeEntity_empId")
	// @JoinColumn(name = "emp_empid", nullable = false)
	 @JsonIgnore
	private EmployeeEntity employeeEntity;

	public Long getSalId() {
		return salId;
	}

	public void setSalId(Long salId) {
		this.salId = salId;
	}

	public EmployeeEntity getBookCategory() {
		return employeeEntity;
	}

	public void setBookCategory(EmployeeEntity bookCategory) {
		this.employeeEntity = bookCategory;
	}

	public long getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(long grossSalary) {
		this.grossSalary = grossSalary;
	}

	public long getBasic() {
		return basic;
	}

	public void setBasic(long basic) {
		this.basic = basic;
	}

	public long getHra() {
		return hra;
	}

	public void setHra(long hra) {
		this.hra = hra;
	}

	public long getCityCompAllow() {
		return cityCompAllow;
	}

	public void setCityCompAllow(long cityCompAllow) {
		this.cityCompAllow = cityCompAllow;
	}

	public long getConveyance() {
		return conveyance;
	}

	public void setConveyance(long conveyance) {
		this.conveyance = conveyance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (basic ^ (basic >>> 32));
		result = prime * result + (int) (cityCompAllow ^ (cityCompAllow >>> 32));
		result = prime * result + (int) (conveyance ^ (conveyance >>> 32));
		result = prime * result + (int) (grossSalary ^ (grossSalary >>> 32));
		result = prime * result + (int) (hra ^ (hra >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaryEmployeeEntity other = (SalaryEmployeeEntity) obj;
		if (basic != other.basic)
			return false;
		if (cityCompAllow != other.cityCompAllow)
			return false;
		if (conveyance != other.conveyance)
			return false;
		if (grossSalary != other.grossSalary)
			return false;
		if (hra != other.hra)
			return false;
		return true;
	}

}
