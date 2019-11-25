package com.poc.springboot.Repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.springboot.entity.EmpLoyeeInfoEntity;

@Repository
public interface EmployeeInfoRepo extends JpaRepository<EmpLoyeeInfoEntity, Long>  {
	
	@Query("select c from EmpLoyeeInfoEntity c where c.empName=:empName")
	public List<EmpLoyeeInfoEntity> findByEmpName(String  empName);
	
	/*
	 * @Modifying
	 * 
	 * @Query("delete from EmpLoyeeInfoEntity e where e.empName=:empName")
	 * 
	 * @Transactional void deleteEmpName(String empName); //List<Course>
	 * findByCourseIdAndModuleIdIn(Long courseId, List<Long> moduleIds);
	 */
}
