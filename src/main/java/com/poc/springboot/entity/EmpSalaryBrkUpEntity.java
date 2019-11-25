package com.poc.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp_salary")
public class EmpSalaryBrkUpEntity {
	
	private String characterName;
	
	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
   public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

@OneToOne(fetch=FetchType.LAZY)
//@JsonIgnore
//@JsonBackReference
	private EmpLoyeeInfoEntity empLoyeeInfoEntity;
   
   @OneToOne(fetch = FetchType.LAZY)
  // @JsonIgnore
  // @JsonBackReference
	private SalaryEmployeeEntity salaryEmployeeEntity;

	public EmpLoyeeInfoEntity getEmpLoyeeInfoEntity() {
		return empLoyeeInfoEntity;
	}

	public void setEmpLoyeeInfoEntity(EmpLoyeeInfoEntity empLoyeeInfoEntity) {
		this.empLoyeeInfoEntity = empLoyeeInfoEntity;
	}

	public SalaryEmployeeEntity getSalaryEmployeeEntity() {
		return salaryEmployeeEntity;
	}

	public void setSalaryEmployeeEntity(SalaryEmployeeEntity salaryEmployeeEntity) {
		this.salaryEmployeeEntity = salaryEmployeeEntity;
	}

}
