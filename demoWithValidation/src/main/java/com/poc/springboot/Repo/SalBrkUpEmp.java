package com.poc.springboot.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.springboot.entity.EmpSalaryBrkUpEntity;

@Repository
public interface SalBrkUpEmp  extends JpaRepository<EmpSalaryBrkUpEntity, Long> {
	
	List<EmpSalaryBrkUpEntity> findByCharacterName(String empName);

}
