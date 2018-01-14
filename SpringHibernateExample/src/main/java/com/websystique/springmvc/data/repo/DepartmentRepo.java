package com.websystique.springmvc.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Department;
import com.websystique.springmvc.model.DepartmentEmployeesCount;
import com.websystique.springmvc.model.DepartmentEmployeesSummary;

@Repository("departmentRepo")
public interface DepartmentRepo extends CrudRepository<Department, Integer> {
	
//	@Query(value = "SELECT d.id as department_id, d.name as department_name, e.name as manager, count(e.id) as employees_count, sum(e.salary) as total_salary_per_department FROM Employee e join e.department d GROUP BY d.name", nativeQuery=false)
//	List<Object> getTotalSalAndEmpCount();
	@Query(value = "SELECT new com.websystique.springmvc.model.DepartmentEmployeesSummary(d.id, d.name, e.name, count(e.id), sum(e.salary)) FROM Employee e join e.department d GROUP BY d.name", nativeQuery=false)
	List<DepartmentEmployeesSummary> getTotalSalAndEmpCount();
	
//	@Query(value = "SELECT d.id as department_id, d.name as department_name, count(e.id) as employees_count FROM Employee e join e.department d GROUP BY d.name ORDER BY employees_count", nativeQuery = false)
	@Query(value = "SELECT new com.websystique.springmvc.model.DepartmentEmployeesCount(d.id as department_id, d.name as department_name, count(e.id) as employees_count) FROM Employee e join e.department d GROUP BY d.name ORDER BY employees_count", nativeQuery = false)
	List<DepartmentEmployeesCount> getTotalEmployeesCount();
}
