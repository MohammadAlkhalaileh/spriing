package com.websystique.springmvc.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.EmployeesMaritalStatus;
import com.websystique.springmvc.model.SumOfSalaryInCity;
import com.websystique.springmvc.model.TotalSalaryInDepartment;

@Repository("employeeRepo")
public interface EmployeeRepo extends CrudRepository<Employee , Integer>{
	
	@Query(value = "SELECT new com.websystique.springmvc.model.SumOfSalaryInCity(a.city, sum(e.salary))"
			+ " FROM Employee e join e.address a GROUP BY a.city", nativeQuery=false)
	List<SumOfSalaryInCity> getTotalSalInCity();

    @Query(value = "SELECT new com.websystique.springmvc.model.EmployeesMaritalStatus(m.name , count(e)) FROM Employee e join e.maritalStatus m GROUP BY m.name", nativeQuery=false)
	List<EmployeesMaritalStatus> getTotalEmpCount();	
	
	
	@Query(value = "SELECT new com.websystique.springmvc.model.TotalSalaryInDepartment(d.name , t.name , sum(e.salary)) FROM Employee e join e.department d "
			+ "join e.title t GROUP BY d.name , t.name", nativeQuery=false)
	List<TotalSalaryInDepartment> getTotalSalInDepInTitle();
	
}
