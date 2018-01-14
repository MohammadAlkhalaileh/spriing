package com.websystique.springmvc.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.data.repo.EmployeeRepo;
import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.EmployeesMaritalStatus;
import com.websystique.springmvc.model.SumOfSalaryInCity;
import com.websystique.springmvc.model.TotalSalaryInDepartment;
import com.websystique.springmvc.service.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeDataServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeRepo")
	private EmployeeRepo empRepo;
	
	@Override
	public Employee findById(int id) {
		return empRepo.findOne(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		empRepo.save(employee);
	}

	//automatically does what you want. If the entity is new it will call persist on the entity manager, otherwise it will call merge
	@Override
	public void updateEmployee(Employee employee) {
		empRepo.save(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		empRepo.delete(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return (List<Employee>) empRepo.findAll();
	}

	@Override
	public List<SumOfSalaryInCity> getTotalSalInCity() {
		
		return empRepo.getTotalSalInCity();
	}

	@Override
	public List<EmployeesMaritalStatus> getTotalEmpCount() {
		return empRepo.getTotalEmpCount();
	}

	@Override
	public List<TotalSalaryInDepartment> getTotalSalInDepInTitle() {
		
		return empRepo.getTotalSalInDepInTitle();
	}

}
