package com.websystique.springmvc.model;

import java.math.BigDecimal;

public class TotalSalaryInDepartment {

	private BigDecimal totalSalaries;
	private String departmentName;
	private String titleName;
	
	public TotalSalaryInDepartment() {
		super();
	}

	public TotalSalaryInDepartment(String departmentName  ,String titleName  , BigDecimal totalSalaries) {
		super();
		this.totalSalaries = totalSalaries;
		this.departmentName = departmentName;
		this.titleName = titleName;
	}

	public BigDecimal getTotalSalaries() {
		return totalSalaries;
	}

	public void setTotalSalaries(BigDecimal totalSalaries) {
		this.totalSalaries = totalSalaries;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	@Override
	public String toString() {
		return "TotalSalaryInDepartment [totalSalaries=" + totalSalaries + ", departmentName=" + departmentName
				+ ", titleName=" + titleName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((titleName == null) ? 0 : titleName.hashCode());
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
		TotalSalaryInDepartment other = (TotalSalaryInDepartment) obj;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (titleName == null) {
			if (other.titleName != null)
				return false;
		} else if (!titleName.equals(other.titleName))
			return false;
		if (totalSalaries == null) {
			if (other.totalSalaries != null)
				return false;
		} else if (!totalSalaries.equals(other.totalSalaries))
			return false;
		return true;
	}
	
	
}
