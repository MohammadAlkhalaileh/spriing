package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.EmployeeDao_old;
import com.websystique.springmvc.model.Employee_old;

//@Service("employeeService")
//@Transactional
public class EmployeeServiceImpl_old implements EmployeeService_old {

	@Autowired
	private EmployeeDao_old dao;
	
	public Employee_old findById(int id) {
		return dao.findById(id);
	}

	public void saveEmployee(Employee_old employee) {
		dao.saveEmployee(employee);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateEmployee(Employee_old employee) {
		Employee_old entity = dao.findById(employee.getId());
		if(entity!=null){
			entity.setName(employee.getName());
			entity.setJoiningDate(employee.getJoiningDate());
			entity.setSalary(employee.getSalary());
			entity.setSsn(employee.getSsn());
		}
	}

	public void deleteEmployeeBySsn(String ssn) {
		dao.deleteEmployeeBySsn(ssn);
	}
	
	public List<Employee_old> findAllEmployees() {
		return dao.findAllEmployees();
	}

	public Employee_old findEmployeeBySsn(String ssn) {
		return dao.findEmployeeBySsn(ssn);
	}

	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee_old employee = findEmployeeBySsn(ssn);
		return ( employee == null || ((id != null) && (employee.getId() == id)));
	}
	
}
