package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.UserProfile;

//@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile>implements UserProfileDao{

	public UserProfile findById(int id) {
		UserProfile up = getByKey(id);
		if(up!=null){
			Hibernate.initialize(up.getPrivileges());
		}
		return up;
	}

	public UserProfile findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		UserProfile up = (UserProfile) crit.uniqueResult();
		if(up!=null){
			Hibernate.initialize(up.getPrivileges());
		}
		return up;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserProfile> findAll(){
		System.out.println(">>>>>>>>>>>>>>>>> UserProfileDaoImpl: findAll <<<<<<<<<<<<<<<<<<");
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<UserProfile>)crit.list();
	}

	@Override
	public void saveUserProfile(UserProfile userProfile) {
		persist(userProfile);
	}
	
}
