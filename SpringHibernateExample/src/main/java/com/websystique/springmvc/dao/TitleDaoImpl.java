package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.websystique.springmvc.model.Title;

@Repository("titleDao")
public class TitleDaoImpl extends AbstractDao<Integer, Title> implements TitleDao{

	@Override
	public Title findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveTitle(Title title) {
		persist(title);
		
	}

	@Override
	public void deleteTitleById(int id) {
		Query query = getSession().createSQLQuery("delete from titles_lookup where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Title> findAllTitles() {
		Criteria criteria = createEntityCriteria();
		return (List<Title>) criteria.list();
	}

}
