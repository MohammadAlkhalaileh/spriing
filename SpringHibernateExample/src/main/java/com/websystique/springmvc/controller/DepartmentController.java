package com.websystique.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Department;
import com.websystique.springmvc.model.DepartmentEmployeesCount;
import com.websystique.springmvc.model.DepartmentEmployeesSummary;
import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.service.DepartmentService;
import com.websystique.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/department")
public class DepartmentController extends AbstractController{

	@Autowired
	EmployeeService employeeService;

	@Autowired
	DepartmentService departmentService;

	
	@RequestMapping(value = { "departments-form" }, method = RequestMethod.GET)
	public String departmentPageLoader(ModelMap model) {
		loadFormDataToModel(model);
		Department department = new Department();
		model.addAttribute(department);
		model.addAttribute("edit", false);
		return DEPARTMENTS;
	}

	@RequestMapping(value = { "departments-form" }, method = RequestMethod.POST)
	public String addDepartment(@Valid @ModelAttribute("department") Department department, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			loadFormDataToModel(model);
			model.addAttribute("edit", false);
			return DEPARTMENTS;
		}

		System.out.println("dept:" + department);
		departmentService.saveDepartment(department);

		model.addAttribute("success", "Department " + department.getName() + " registered successfully");
		return "redirect:departments-form";
	}

	@RequestMapping(value = { "/edit-{departmentId}-department" }, method = RequestMethod.GET)
	public String editDepartment(@PathVariable("departmentId") Integer departmentId, ModelMap model) {
		
		loadFormDataToModel(model);
		Department dept = departmentService.findById(departmentId);
//		model.addAttribute("department", departmentService.findById(departmentId));
		model.addAttribute("department", dept);
		model.addAttribute("edit", true);
		return DEPARTMENTS;
	}

	@RequestMapping(value = { "/edit-{departmentId}-department" }, method = RequestMethod.POST)
	public String updateDepartment(@Valid @ModelAttribute("department") Department department,
			ModelMap model, BindingResult result, @PathVariable Integer departmentId) {
		if (result.hasErrors()) {
			loadFormDataToModel(model);
			model.addAttribute("edit", true);
			return DEPARTMENTS;
		}
		department.setId(departmentId);
		departmentService.updateDepartment(department);

		return "redirect:departments-form";
	}
	
	@RequestMapping(value = { "/delete-{departmentId}-department" }, method = RequestMethod.GET)
	public String deleteDepartment(@PathVariable("departmentId") Integer departmentId, ModelMap model) {
		departmentService.deleteDepartmentById(departmentId);
		return "redirect:departments-form";
	}
	
	@RequestMapping(value = {"/DepartmentsEmployeesSummaryReport"}, method = RequestMethod.GET)
	public String getDepartmentsEmployeeSummary(ModelMap model){
		List<DepartmentEmployeesSummary> report = departmentService.getTotalSalAndEmpCount();
		model.addAttribute("departmentsReport", report);
		return REPORT1;
	}
	
	@RequestMapping(value = {"/DepartmentsEmployeesCountReport"}, method = RequestMethod.GET)
	public String getDepartmentsEmployeeCount(ModelMap model){
		List<DepartmentEmployeesCount> report = departmentService.getTotalEmployeesCount();
		model.addAttribute("departmentsReport", report);
		return REPORT2;
	}
	
	private void loadFormDataToModel(ModelMap model) {
		List<Employee> employees = employeeService.findAllEmployees();
		List<Department> departments = departmentService.findAllDepartments();
		model.addAttribute("employees", employees);
		model.addAttribute("departments", departments);
	}

	
}
