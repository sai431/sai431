package com.poc.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TBL_EMPLOYEES")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EmployeeEntity {

	public EmployeeEntity() {
		super();

	}

	public EmployeeEntity(Long empId, String empName, String role, List<SalaryEmployeeEntity> salaryEmployeeEntity) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.role = role;
		this.salaryEmployeeEntity = salaryEmployeeEntity;
	}

	@Id
	@GeneratedValue
	private Long empId;

	@Column
	private String empName;

	@Column
	private String role;

	@OneToMany( mappedBy = "employeeEntity")
	@JsonIgnore
	private List<SalaryEmployeeEntity> salaryEmployeeEntity;

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

	public List<SalaryEmployeeEntity> getSalaryEmployeeEntity() {
		return salaryEmployeeEntity;
	}

	public void setSalaryEmployeeEntity(List<SalaryEmployeeEntity> salaryEmployeeEntity) {
		this.salaryEmployeeEntity = salaryEmployeeEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((salaryEmployeeEntity == null) ? 0 : salaryEmployeeEntity.hashCode());
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
		EmployeeEntity other = (EmployeeEntity) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (salaryEmployeeEntity == null) {
			if (other.salaryEmployeeEntity != null)
				return false;
		} else if (!salaryEmployeeEntity.equals(other.salaryEmployeeEntity))
			return false;
		return true;
	}

}
