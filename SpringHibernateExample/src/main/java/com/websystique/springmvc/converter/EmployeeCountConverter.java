package com.websystique.springmvc.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.websystique.springmvc.model.DepartmentEmployeesCount;

@Component
public class EmployeeCountConverter implements Converter<Object, DepartmentEmployeesCount> {

	
	@Override
	public DepartmentEmployeesCount convert(Object arg0) {
		return new DepartmentEmployeesCount(3, "IT", 500);
	}

}
