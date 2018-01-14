package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.websystique.springmvc.model.User_old;


//@Repository("userDao")
public class UserDaoImpl_old extends AbstractDao<Integer, User_old> implements UserDao_old{

	@Override
	public User_old findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveUser(User_old user) {
		persist(user);		
	}

	@Override
	public void deleteUserById(int id) {
		Query query = getSession().createSQLQuery("delete from user where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_old> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User_old>) criteria.list();
	}

	@Override
	public User_old findUserById(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (User_old) criteria.uniqueResult();
	}

	@Override
	public User_old findUserByUsername(User_old user) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", user.getUsername()));
		return (User_old) criteria.uniqueResult();
	}

}
