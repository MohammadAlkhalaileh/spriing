package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.MaritalStatusDao;
import com.websystique.springmvc.model.MaritalStatus;

@Service
@Transactional
public class MaritalStatusServiceImpl implements MaritalStatusService {

	@Autowired
	private MaritalStatusDao dao;
	
	@Override
	public MaritalStatus findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveMaritalStatus(MaritalStatus maritalStatus) {
		dao.saveMaritalStatus(maritalStatus);
	}

	@Override
	public void updateMaritalStatus(MaritalStatus maritalStatus) {
		MaritalStatus entity = dao.findById(maritalStatus.getId());
		if(entity != null){
			entity.setName(maritalStatus.getName());
		}
	}

	@Override
	public void deleteMaritalStatusById(int id) {
		dao.deleteMaritalStatusById(id);
	}

	@Override
	public List<MaritalStatus> findAllMaritalStatus() {
		return dao.findAllMaritalStatuses();
	}

}
