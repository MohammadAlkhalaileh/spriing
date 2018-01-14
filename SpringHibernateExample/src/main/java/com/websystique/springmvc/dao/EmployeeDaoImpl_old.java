package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Employee_old;

@Repository("employeeDao_old")
public class EmployeeDaoImpl_old extends AbstractDao<Integer, Employee_old> implements EmployeeDao_old {

	public Employee_old findById(int id) {
		return getByKey(id);
	}

	public void saveEmployee(Employee_old employee) {
		persist(employee);
	}

	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Employee_old> findAllEmployees() {
		Criteria criteria = createEntityCriteria();
		return (List<Employee_old>) criteria.list();
	}

	public Employee_old findEmployeeBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee_old) criteria.uniqueResult();
	}
}
