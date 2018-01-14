package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.websystique.springmvc.model.MaritalStatus;

@Repository("maritalStatusDao")
public class MaritalStatusDaoImpl extends AbstractDao<Integer, MaritalStatus> implements MaritalStatusDao {

	@Override
	public MaritalStatus findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveMaritalStatus(MaritalStatus maritalStatus) {
		persist(maritalStatus);		
	}

	@Override
	public void deleteMaritalStatusById(int id) {
		Query query = getSession().createSQLQuery("delete from marital_statuses_lookup where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MaritalStatus> findAllMaritalStatuses() {
		Criteria criteria = createEntityCriteria();
		return (List<MaritalStatus>) criteria.list();
	}

}
