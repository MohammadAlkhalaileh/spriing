package com.websystique.springmvc.comparators;

import java.util.Comparator;

import com.websystique.springmvc.model.Employee;

public class EmployeeSalaryComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.getSalary().compareTo(o1.getSalary());

	}

}
