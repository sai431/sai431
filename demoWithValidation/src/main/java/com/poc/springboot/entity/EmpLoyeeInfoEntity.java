package com.poc.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TBL_EMPLOYEE_INFO")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EmpLoyeeInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;

	@Column
	private String empName;

	@Column
	private String role;

	@Column
	private Long salaryCtc;

	/*
	 * @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) private
	 * EmpSalaryBrkUpEntity empsalbrk;
	 */

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empLoyeeInfoEntity", orphanRemoval = true)
	private SalaryBreakupEntity salaryBreakupEntity;

	public SalaryBreakupEntity getSalaryBreakupEntity() {
		return salaryBreakupEntity;
	}

	public void setSalaryBreakupEntity(SalaryBreakupEntity salaryBreakupEntity) {
		this.salaryBreakupEntity = salaryBreakupEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((salaryCtc == null) ? 0 : salaryCtc.hashCode());
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
		EmpLoyeeInfoEntity other = (EmpLoyeeInfoEntity) obj;
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
		if (salaryCtc == null) {
			if (other.salaryCtc != null)
				return false;
		} else if (!salaryCtc.equals(other.salaryCtc))
			return false;
		return true;
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

	public Long getSalaryCtc() {
		return salaryCtc;
	}

	public void setSalaryCtc(Long salaryCtc) {
		this.salaryCtc = salaryCtc;
	}

}
