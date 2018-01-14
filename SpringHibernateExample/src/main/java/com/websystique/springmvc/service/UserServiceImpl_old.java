package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.websystique.springmvc.dao.UserDao_old;
import com.websystique.springmvc.model.User_old;

//@Service("userService")
//@Transactional
public class UserServiceImpl_old implements UserService_old{

	@Autowired
	private UserDao_old dao;
	
	@Override
	public User_old findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveUser(User_old user) {
		dao.saveUser(user);
	}

	@Override
	public void updateUser(User_old user) {
		User_old entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setUsername(user.getUsername());
			entity.setPassword(user.getPassword());
		}
		
	}

	@Override
	public void deleteEmployeeBySsn(int id) {
		dao.deleteUserById(id);
	}

	@Override
	public List<User_old> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public User_old findUserByUsername(User_old user) {
		return dao.findUserByUsername(user);
	}

}
