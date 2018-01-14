package com.websystique.springmvc.dao;

import java.util.List;
import com.websystique.springmvc.model.Privilege;

public interface PrivilegeDao {

	Privilege findById(int id);
	
	Privilege findByName(String name);
	
	void savePrivilege(Privilege privilege);
	
	void deletePrivilegeById(int id);
	
	List<Privilege> findAllPrivileges();
}
