package com.websystique.springmvc.model;

import java.math.BigDecimal;

public class DepartmentEmployeesSummary {
	
	private int departmentId;
	private String departmentName;
	private String departmentManager;
	private long employeesCount;
	private BigDecimal totalSalaries;
	
	public DepartmentEmployeesSummary(){
		super();
	}
	
	public DepartmentEmployeesSummary(int departmentId, String departmentName, String departmentManager,
			long employeesCount, BigDecimal totalSalaries) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentManager = departmentManager;
		this.employeesCount = employeesCount;
		this.totalSalaries = totalSalaries;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentManager() {
		return departmentManager;
	}
	public void setDepartmentManager(String departmentManager) {
		this.departmentManager = departmentManager;
	}
	public long getEmployeesCount() {
		return employeesCount;
	}
	public void setEmployeesCount(long employeesCount) {
		this.employeesCount = employeesCount;
	}
	public BigDecimal getTotalSalaries() {
		return totalSalaries;
	}
	public void setTotalSalaries(BigDecimal totalSalaries) {
		this.totalSalaries = totalSalaries;
	}
	@Override
	public String toString() {
		return "DepartmentEmployeesSummary [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentManager=" + departmentManager + ", employeesCount=" + employeesCount + ", totalSalaries="
				+ totalSalaries + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentId;
		result = prime * result + ((departmentManager == null) ? 0 : departmentManager.hashCode());
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + (int) (employeesCount ^ (employeesCount >>> 32));
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
		DepartmentEmployeesSummary other = (DepartmentEmployeesSummary) obj;
		if (departmentId != other.departmentId)
			return false;
		if (departmentManager == null) {
			if (other.departmentManager != null)
				return false;
		} else if (!departmentManager.equals(other.departmentManager))
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (employeesCount != other.employeesCount)
			return false;
		if (totalSalaries == null) {
			if (other.totalSalaries != null)
				return false;
		} else if (!totalSalaries.equals(other.totalSalaries))
			return false;
		return true;
	}
}
