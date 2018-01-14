package com.websystique.springmvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.websystique.springmvc.dao.EmployeeDao;
import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.EmployeesMaritalStatus;
import com.websystique.springmvc.model.SumOfSalaryInCity;
import com.websystique.springmvc.model.TotalSalaryInDepartment;

//@Service
//@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public Employee findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Employee entity = dao.findById(employee.getId());
		if(entity != null){
			entity.setName(employee.getName());
//			entity.setDateOfBirth(employee.getDateOfBirth());
//			entity.setDateOfHire(employee.getDateOfHire());
			entity.setDepartment(employee.getDepartment());
			entity.setMaritalStatus(employee.getMaritalStatus());
			entity.setSalary(employee.getSalary());
			entity.setTitle(employee.getTitle());
		}
	}

	@Override
	public void deleteEmployeeById(int id) {
		dao.deleteEmployeeById(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}

	@Override
	public List<SumOfSalaryInCity> getTotalSalInCity() {
		return ((EmployeeServiceImpl) dao).getTotalSalInCity();
		
	}

	@Override
	public List<EmployeesMaritalStatus> getTotalEmpCount() {
		return ((EmployeeServiceImpl) dao).getTotalEmpCount();
	}

	@Override
	public List<TotalSalaryInDepartment> getTotalSalInDepInTitle() {
		
		return ((EmployeeServiceImpl) dao).getTotalSalInDepInTitle();
	}

}
