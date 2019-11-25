package com.poc.springboot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.springboot.entity.EmpLoyeeInfoEntity;
import com.poc.springboot.entity.EmployeeEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmployeeEntity, Long> {

	//void saveAll(EmpLoyeeInfoEntity employeeEntity);

}
