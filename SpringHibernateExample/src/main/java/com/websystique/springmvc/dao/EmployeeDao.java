package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.SumOfSalaryInCity;


public interface EmployeeDao {

	Employee findById(int id);

	void saveEmployee(Employee employee);

	void deleteEmployeeById(int id);

	List<Employee> findAllEmployees();

	
	
}
