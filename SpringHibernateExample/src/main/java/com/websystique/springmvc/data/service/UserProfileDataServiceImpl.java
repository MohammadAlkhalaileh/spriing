package com.websystique.springmvc.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.data.repo.UserProfileRepo;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserProfileService;

@Service("userProfileService")
@Transactional
public class UserProfileDataServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileRepo userProfileRepo;
	
	@Override
	public void saveUserProfile(UserProfile userProfile) {
		userProfileRepo.save(userProfile);
	}

	@Override
	public UserProfile findById(int id) {
		return userProfileRepo.findOne(id);
	}

	@Override
	public UserProfile findByType(String type) {
		return userProfileRepo.findByType(type);
	}

	@Override
	public List<UserProfile> findAll() {
		return (List<UserProfile>) userProfileRepo.findAll();
	}

}
