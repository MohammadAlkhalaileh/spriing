package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.DepartmentDao;
import com.websystique.springmvc.model.Department;
import com.websystique.springmvc.model.DepartmentEmployeesCount;
import com.websystique.springmvc.model.DepartmentEmployeesSummary;

//@Service
//@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	@Qualifier("departmentDao")
	private DepartmentDao dao;
	
	@Override
	public Department findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveDepartment(Department department) {
		dao.saveDepartment(department);
	}

	@Override
	public void deleteDepartmentById(int id) {
		dao.deleteDepartmentById(id);
	}

	@Override
	public void updateDepartment(Department department) {
		Department entity = dao.findById(department.getId());
		if(entity != null){
			entity.setName(department.getName());
			entity.setLocation(department.getLocation());
			entity.setManager(department.getManager());
		}
	}

	@Override
	public List<Department> findAllDepartments() {
		return dao.findAllDepartments();
	}

	@Override
	public List<DepartmentEmployeesSummary> getTotalSalAndEmpCount() {
		return dao.getTotalSalAndEmpCount();
	}

	@Override
	public List<DepartmentEmployeesCount> getTotalEmployeesCount() {
		return dao.getTotalEmployeesCount();
	}


}
