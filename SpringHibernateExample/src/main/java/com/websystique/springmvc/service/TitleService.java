package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Title;


public interface TitleService {

	Title findById(int id);

	void saveTitle(Title title);

	void updateTitle(Title title);

	void deleteTitleById(int id);

	List<Title> findAllTitles();
}
