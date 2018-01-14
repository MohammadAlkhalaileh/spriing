package com.websystique.springmvc.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;

@Repository("userRepo")
public interface UserRepo extends CrudRepository<User, Integer> {

	User findBySsoId(String sso);
	
	void deleteBySsoId(String sso);
}
