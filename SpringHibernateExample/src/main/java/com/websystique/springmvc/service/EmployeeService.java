package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.EmployeesMaritalStatus;
import com.websystique.springmvc.model.SumOfSalaryInCity;
import com.websystique.springmvc.model.TotalSalaryInDepartment;

public interface EmployeeService {
	
	Employee findById(int id);

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployeeById(int id);

	List<Employee> findAllEmployees();
	
	List<SumOfSalaryInCity> getTotalSalInCity();
	
	List<EmployeesMaritalStatus> getTotalEmpCount();
	
	List<TotalSalaryInDepartment> getTotalSalInDepInTitle();
}
