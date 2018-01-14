package com.websystique.springmvc.model;

import java.math.BigDecimal;

public class SumOfSalaryInCity {

	private String employeeCity;
	private BigDecimal totalSalaries;
	
	
	public SumOfSalaryInCity() {
		super();
	}
	public SumOfSalaryInCity(String employeeCity, BigDecimal totalSalaries) {
		super();
		this.employeeCity = employeeCity;
		this.totalSalaries = totalSalaries;
	}
	public String getEmployeeCity() {
		return employeeCity;
	}
	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}
	public BigDecimal getTotalSalaries() {
		return totalSalaries;
	}
	public void setTotalSalaries(BigDecimal totalSalaries) {
		this.totalSalaries = totalSalaries;
	}
	@Override
	public String toString() {
		return "SumOfSalaryInCity [employeeCity=" + employeeCity + ", totalSalaries=" + totalSalaries + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeCity == null) ? 0 : employeeCity.hashCode());
		result = prime * result + ((totalSalaries == null) ? 0 : totalSalaries.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SumOfSalaryInCity other = (SumOfSalaryInCity) obj;
		if (employeeCity == null) {
			if (other.employeeCity != null)
				return false;
		} else if (!employeeCity.equals(other.employeeCity))
			return false;
		if (totalSalaries == null) {
			if (other.totalSalaries != null)
				return false;
		} else if (!totalSalaries.equals(other.totalSalaries))
			return false;
		return true;
	}
	
	
}
