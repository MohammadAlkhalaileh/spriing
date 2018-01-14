package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.websystique.springmvc.dao.PrivilegeDao;
import com.websystique.springmvc.model.Privilege;

public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeDao dao;
	
	@Override
	public Privilege findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void savePrivilege(Privilege privilege) {
		dao.savePrivilege(privilege);
		
	}

	@Override
	public void deletePrivilegeById(int id) {
		// TODO Auto-generated method stub
		dao.deletePrivilegeById(id);
	}

	@Override
	public List<Privilege> findAllPrivileges() {
		// TODO Auto-generated method stub
		return dao.findAllPrivileges();
	}

	@Override
	public Privilege findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

}
