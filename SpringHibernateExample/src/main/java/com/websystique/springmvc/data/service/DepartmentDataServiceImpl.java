package com.websystique.springmvc.data.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.data.repo.DepartmentRepo;
import com.websystique.springmvc.model.Department;
import com.websystique.springmvc.model.DepartmentEmployeesCount;
import com.websystique.springmvc.model.DepartmentEmployeesSummary;
import com.websystique.springmvc.service.DepartmentService;

@Service("departmentService")
@Transactional
public class DepartmentDataServiceImpl implements DepartmentService {

	@Autowired
	@Qualifier("departmentRepo")
	private DepartmentRepo deptRepo;
	
	@Override
	public Department findById(int id) {
		return deptRepo.findOne(id);
	}

	@Override
	public void saveDepartment(Department department) {
		deptRepo.save(department);		
	}

	@Override
	public void deleteDepartmentById(int id) {
		deptRepo.delete(id);	
	}

	@Override
	public void updateDepartment(Department department) {
		deptRepo.save(department);
	}

	@Override
	public List<Department> findAllDepartments() {
		return (List<Department>) deptRepo.findAll();
	}

	@Override
	public List<DepartmentEmployeesSummary> getTotalSalAndEmpCount() {
//		List<DepartmentEmployeesSummary> list = new ArrayList<DepartmentEmployeesSummary>();
//		List<Object> result = deptRepo.getTotalSalAndEmpCount(); 
//		System.out.println(">>>>>>>>>>>>>>> SIZE; " + result.size());
//		return list;
		
		return deptRepo.getTotalSalAndEmpCount();
	}

	@Override
	public List<DepartmentEmployeesCount> getTotalEmployeesCount() {
		return deptRepo.getTotalEmployeesCount();
	}

}
