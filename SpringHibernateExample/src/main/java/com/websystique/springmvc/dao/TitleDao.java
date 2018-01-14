package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Title;

public interface TitleDao {

	Title findById(int id);

	void saveTitle(Title title);

	void deleteTitleById(int id);

	List<Title> findAllTitles();

}
