package com.websystique.springmvc.model;

public class DepartmentEmployeesCount {

	private int departmentId;
	private String departmentName;
	private long employeesCount;
	
	public int getDepartmentId() {
		return departmentId;
	}
	
	public DepartmentEmployeesCount(int departmentId, String departmentName, long employeesCount) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employeesCount = employeesCount;
	}

	public DepartmentEmployeesCount(){
		super();
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
	public long getEmployeesCount() {
		return employeesCount;
	}
	public void setEmployeesCount(int employeesCount) {
		this.employeesCount = employeesCount;
	}
	@Override
	public String toString() {
		return "DepartmentEmployeesCount [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", employeesCount=" + employeesCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentId;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + (int) (employeesCount ^ (employeesCount >>> 32));
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
		DepartmentEmployeesCount other = (DepartmentEmployeesCount) obj;
		if (departmentId != other.departmentId)
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (employeesCount != other.employeesCount)
			return false;
		return true;
	}
	
}
