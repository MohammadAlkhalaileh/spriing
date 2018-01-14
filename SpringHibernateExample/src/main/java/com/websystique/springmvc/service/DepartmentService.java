package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Department;
import com.websystique.springmvc.model.DepartmentEmployeesCount;
import com.websystique.springmvc.model.DepartmentEmployeesSummary;

public interface DepartmentService {

	Department findById(int id);
	
	void saveDepartment(Department department);
	
	void deleteDepartmentById(int id);
	
	void updateDepartment(Department department);
	
	List<Department> findAllDepartments();
	
	List<DepartmentEmployeesSummary> getTotalSalAndEmpCount();
	
	List<DepartmentEmployeesCount> getTotalEmployeesCount();
}
