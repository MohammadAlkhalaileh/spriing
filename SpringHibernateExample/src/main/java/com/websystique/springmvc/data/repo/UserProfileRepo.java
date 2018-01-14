package com.websystique.springmvc.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.UserProfile;

@Repository("userProfileRepo")
public interface UserProfileRepo extends CrudRepository<UserProfile, Integer> {

	UserProfile findByType(String type);
}
