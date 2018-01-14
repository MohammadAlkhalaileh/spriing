package com.websystique.springmvc.model;

public class EmployeesMaritalStatus {
	
	private long  totalEmployee;
	private String maritalStatus;
	public long getTotalEmployee() {
		return totalEmployee;
	}
	public void setTotalEmployee(long totalEmployee) {
		this.totalEmployee = totalEmployee;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public EmployeesMaritalStatus() {
		super();
	}
	public EmployeesMaritalStatus(String maritalStatus, long totalEmployee) {
		super();
		this.totalEmployee = totalEmployee;
		this.maritalStatus = maritalStatus;
	}
	@Override
	public String toString() {
		return "EmployeesMaritalStatus [totalEmployee=" + totalEmployee + ", maritalStatus=" + maritalStatus + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
		result = prime * result + (int) (totalEmployee ^ (totalEmployee >>> 32));
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
		EmployeesMaritalStatus other = (EmployeesMaritalStatus) obj;
		if (maritalStatus == null) {
			if (other.maritalStatus != null)
				return false;
		} else if (!maritalStatus.equals(other.maritalStatus))
			return false;
		if (totalEmployee != other.totalEmployee)
			return false;
		return true;
	}
	
	
	
	
}