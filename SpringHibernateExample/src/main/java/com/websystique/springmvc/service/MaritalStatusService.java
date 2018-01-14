package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.MaritalStatus;

public interface MaritalStatusService {

	MaritalStatus findById(int id);

	void saveMaritalStatus(MaritalStatus maritalStatus);

	void updateMaritalStatus(MaritalStatus maritalStatus);

	void deleteMaritalStatusById(int id);

	List<MaritalStatus> findAllMaritalStatus();
}
