package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.TitleDao;
import com.websystique.springmvc.model.Title;

@Service
@Transactional
public class TitleServiceImpl implements TitleService{

	@Autowired
	private TitleDao dao;
	
	@Override
	public Title findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveTitle(Title title) {
		dao.saveTitle(title);
	}

	@Override
	public void updateTitle(Title title) {
		Title entity = dao.findById(title.getId());
		if(entity != null){
			title.setName(title.getName());
		}
	}

	@Override
	public void deleteTitleById(int id) {
		dao.deleteTitleById(id);
	}

	@Override
	public List<Title> findAllTitles() {
		return dao.findAllTitles();
	}

}
