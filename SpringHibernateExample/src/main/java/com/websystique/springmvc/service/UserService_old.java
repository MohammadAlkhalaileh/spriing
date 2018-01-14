package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User_old;

public interface UserService_old {

	User_old findById(int id);

	void saveUser(User_old user);

	void updateUser(User_old user);

	void deleteEmployeeBySsn(int id);

	List<User_old> findAllUsers();
	
	User_old findUserByUsername(User_old user);

}
