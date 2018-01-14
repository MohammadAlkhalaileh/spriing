package com.websystique.springmvc.dao;

import java.util.List;
import com.websystique.springmvc.model.User_old;

public interface UserDao_old {

	User_old findById(int id);

	void saveUser(User_old user);

	void deleteUserById(int id);

	List<User_old> findAllUsers();

	User_old findUserById(int id);
	
	User_old findUserByUsername(User_old user);
}
