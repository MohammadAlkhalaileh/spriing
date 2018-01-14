package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Department;
import com.websystique.springmvc.model.DepartmentEmployeesCount;
import com.websystique.springmvc.model.DepartmentEmployeesSummary;

public interface DepartmentDao {

	Department findById(int id);
	
	void saveDepartment(Department department);
	
	void deleteDepartmentById(int id);
	
	List<Department> findAllDepartments();
	
	List<DepartmentEmployeesSummary> getTotalSalAndEmpCount();
	
	List<DepartmentEmployeesCount> getTotalEmployeesCount();
}
