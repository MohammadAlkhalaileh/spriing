package com.websystique.springmvc.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import com.websystique.springmvc.model.Department;
import com.websystique.springmvc.model.DepartmentEmployeesCount;
import com.websystique.springmvc.model.DepartmentEmployeesSummary;

//@Repository("departmentDao")
public class DepartmentDaoImpl extends AbstractDao<Integer, Department> implements DepartmentDao {

	@Override
	public Department findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveDepartment(Department department) {
		persist(department);
	}

	@Override
	public void deleteDepartmentById(int id) {
		Query query = getSession().createSQLQuery("delete from departments where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAllDepartments() {
		Criteria criteria = createEntityCriteria();
		return (List<Department>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentEmployeesSummary> getTotalSalAndEmpCount() {
		Query query = getSession().createQuery(
				"SELECT d.id as department_id, d.name as department_name, e.name as manager, count(e.id) as employees_count, sum(e.salary) as total_salary_per_department FROM Employee e join e.department d GROUP BY d.name");
		List<DepartmentEmployeesSummary> deSummaryList = new ArrayList<>();
		List<Object[]> list = query.list();
		for (Object[] object : list) {
			DepartmentEmployeesSummary deSummary = new DepartmentEmployeesSummary();
			deSummary.setDepartmentId(Integer.parseInt(object[0].toString()));
			deSummary.setDepartmentName(object[1].toString());
			deSummary.setDepartmentManager(object[2].toString());
			deSummary.setEmployeesCount((Long) object[3]);
			// deSummary.setTotalSalaries(Double.parseDouble(object[4].toString()));
			deSummary.setTotalSalaries(new BigDecimal(object[4].toString()));
			deSummaryList.add(deSummary);
		}
		return deSummaryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentEmployeesCount> getTotalEmployeesCount() {
		Query query = getSession().createQuery(
				"SELECT d.id as department_id, d.name as department_name, count(e.id) as employees_count FROM Employee e join e.department d GROUP BY d.name ORDER BY employees_count");
		List<DepartmentEmployeesCount> deCountsList = new ArrayList<>();
		List<Object[]> list = query.list();
		for (Object[] object : list) {
			DepartmentEmployeesCount deCount = new DepartmentEmployeesCount();
			deCount.setDepartmentId(Integer.parseInt(object[0].toString()));
			deCount.setDepartmentName(object[1].toString());
			deCount.setEmployeesCount(Integer.parseInt(object[2].toString()));
			deCountsList.add(deCount);
		}
		return deCountsList;
	}

}
