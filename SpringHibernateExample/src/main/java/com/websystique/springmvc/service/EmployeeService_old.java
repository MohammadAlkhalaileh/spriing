package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Employee_old;

public interface EmployeeService_old {

	Employee_old findById(int id);
	
	void saveEmployee(Employee_old employee);
	
	void updateEmployee(Employee_old employee);
	
	void deleteEmployeeBySsn(String ssn);

	List<Employee_old> findAllEmployees(); 
	
	Employee_old findEmployeeBySsn(String ssn);

	boolean isEmployeeSsnUnique(Integer id, String ssn);
	
}
