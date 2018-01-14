package com.websystique.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.websystique.springmvc.model.Global;

public class AbstractController {

	@Autowired
	Global global;
	protected final static String LOGIN = "login2";
	protected final static String ACCESSDENIED = "accessDenied";
	protected final static String INDEX = "index";
	protected final static String DEPARTMENTS = "departments2";
	protected final static String EMPLOYEES = "employees2";//"employees_old";
	protected final static String REPORT1 = "report1-2";
	protected final static String REPORT2 = "report2-2";
	protected final static String REPORT3 = "report3-2";
	protected final static String REPORT4 = "report4-2";
	protected final static String REPORT5 = "report5-2";
	protected final static String REPORT6 = "report6-2";
	
	public String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}

		return userName;
	}
}
