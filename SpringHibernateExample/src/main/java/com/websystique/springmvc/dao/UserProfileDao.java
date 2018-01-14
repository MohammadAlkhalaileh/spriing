package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.UserProfile;


public interface UserProfileDao {

	void saveUserProfile(UserProfile userProfile);
	
	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
