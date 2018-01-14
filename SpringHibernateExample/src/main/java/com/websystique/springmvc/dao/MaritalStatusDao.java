package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.MaritalStatus;

public interface MaritalStatusDao {

	MaritalStatus findById(int id);
	
	void saveMaritalStatus(MaritalStatus maritalStatus);
	
	void deleteMaritalStatusById(int id);
	
	List<MaritalStatus> findAllMaritalStatuses();
}
