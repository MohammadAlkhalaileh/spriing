package com.websystique.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.comparators.EmployeeSalaryComparator;
import com.websystique.springmvc.model.Department;
import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.EmployeesMaritalStatus;
import com.websystique.springmvc.model.MaritalStatus;
import com.websystique.springmvc.model.SumOfSalaryInCity;
import com.websystique.springmvc.model.Title;
import com.websystique.springmvc.model.TotalSalaryInDepartment;
import com.websystique.springmvc.service.DepartmentService;
import com.websystique.springmvc.service.EmployeeService;
import com.websystique.springmvc.service.MaritalStatusService;
import com.websystique.springmvc.service.TitleService;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends AbstractController{
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	MaritalStatusService maritalStatisService;
	
	@Autowired
	TitleService titleService;

	
	@RequestMapping(value = { "/employees-form" }, method = RequestMethod.GET)
	public String employeePageLoader(ModelMap model,HttpServletRequest req) {
		loadFormDataToModel(model);
		Employee employee = new Employee();
		model.addAttribute(employee);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", (String)req.getSession().getAttribute("username")); 	
		System.out.println("lllllllllllll");
		return EMPLOYEES;
	}
	
	@RequestMapping(value = { "/employees-form" }, method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute() Employee employee, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			loadFormDataToModel(model);
			model.addAttribute("edit", false);
			return EMPLOYEES;
		}

		System.out.println("Emp: " + employee);
		employeeService.saveEmployee(employee);

		return "redirect:employees-form";
	}
	
	@RequestMapping(value = { "/edit-{employeeId}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable("employeeId") Integer employeeId, ModelMap model) {
		loadFormDataToModel(model);
		Employee emp =  employeeService.findById(employeeId);
		model.addAttribute("employee",emp);
		model.addAttribute("edit", true);
		return EMPLOYEES;
	}
	
	@RequestMapping(value = { "/edit-{employeeId}-employee" }, method = RequestMethod.POST)
	public String updateUpdate(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
			ModelMap model, @PathVariable Integer employeeId) {
		if (result.hasErrors()) {
			loadFormDataToModel(model);
			model.addAttribute("edit", true);
			return EMPLOYEES;
		}
		employee.setId(employeeId);
		employeeService.updateEmployee(employee);
		return "redirect:employees-form";
	}
	
	@RequestMapping(value = { "/delete-{employeeId}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("employeeId") Integer employeeId, ModelMap model) {
		employeeService.deleteEmployeeById(employeeId);
		return "redirect:employees-form";
	}
	
	@RequestMapping(value = {"/EmployeesSalariesSummary"}, method = RequestMethod.GET)
	public String getDepartmentsEmployeeCount(ModelMap model){
		List<Employee> employees = employeeService.findAllEmployees();
		employees.sort(new EmployeeSalaryComparator());
		model.addAttribute("employeesReport", employees);
//		model.addAttribute("loggedinuser", getPrincipal()); 
//		model.addAttribute("loggUserName" , getPrincipal());
		return REPORT3;
	}
	
	@RequestMapping(value = {"/SumOfSalaryInCityReport"}, method = RequestMethod.GET)
	public String getSumOfSalaryInCity(ModelMap model){
		List<SumOfSalaryInCity> report = employeeService.getTotalSalInCity();
		model.addAttribute("employeesReport", report);
		return REPORT4;
	}
	
	@RequestMapping(value = {"/EmployeesMaritalStatus"}, method = RequestMethod.GET)
	public String getEmployeesMaritalStatus(ModelMap model){
		List<EmployeesMaritalStatus> report = employeeService.getTotalEmpCount();
		model.addAttribute("employeesReport", report);
		return REPORT5;
	}
	
	@RequestMapping(value = {"/TotalSalaryInDepartment"}, method = RequestMethod.GET)
	public String getTotalSalaryInDepartment(ModelMap model){
		List<TotalSalaryInDepartment> report = employeeService.getTotalSalInDepInTitle();
		model.addAttribute("employeesReport", report);
		return REPORT6;
	}
	private void loadFormDataToModel(ModelMap model){
		List<Employee> employees = employeeService.findAllEmployees();
		List<Department> departments = departmentService.findAllDepartments();
		List<MaritalStatus> maritalStatuses = maritalStatisService.findAllMaritalStatus();
		List<Title> titles = titleService.findAllTitles();
		model.addAttribute("employees", employees);
		model.addAttribute("departments", departments);
		model.addAttribute("maritalStatuses", maritalStatuses);
		model.addAttribute("titles", titles);
	
		
	}
}
