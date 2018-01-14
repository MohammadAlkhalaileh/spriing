package com.websystique.springmvc.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.websystique.springmvc.model.Privilege;
import com.websystique.springmvc.model.User;

@Repository("PrivilegeDao")
public class PrivilegeDaoImpl extends AbstractDao<Integer, Privilege> implements PrivilegeDao {

	@Override
	public Privilege findById(int id) {
		return getByKey(id);
	}

	@Override
	public void savePrivilege(Privilege privilege) {
		persist(privilege);		
	}

	@Override
	public void deletePrivilegeById(int id) {
		Query query = getSession().createSQLQuery("delete from privileges where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> findAllPrivileges() {
		Criteria criteria = createEntityCriteria();
		return (List<Privilege>) criteria.list();
	}

	@Override
	public Privilege findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		Privilege privilege = (Privilege)crit.uniqueResult();
		return privilege;
	}

}
