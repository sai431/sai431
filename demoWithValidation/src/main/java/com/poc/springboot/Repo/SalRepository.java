package com.poc.springboot.Repo;

import java.awt.print.Book;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poc.springboot.entity.SalaryEmployeeEntity;

@Repository
public interface SalRepository extends JpaRepository<SalaryEmployeeEntity, Long> {
	
	List<SalaryEmployeeEntity> findByEmployeeEntityEmpId(Long employeeEntity_empId);
	/*
	 * @Modifying
	 * 
	 * @Query("DELETE EmployeeEntity b WHERE b.category.id = ?1") void
	 * deleteByEmployeeId(int categoryId);
	 * 
	 * List<Book> findByCategoryId(int categoryId);
	 */
	

}
