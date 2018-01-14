package com.websystique.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.DepartmentEmployeesSummary;
import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.SumOfSalaryInCity;

//@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	@Override
	public Employee findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		//Try to make this generic in a super class.
		Query query = getSession().createSQLQuery("delete from employees where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
		Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();
	}

	

}
