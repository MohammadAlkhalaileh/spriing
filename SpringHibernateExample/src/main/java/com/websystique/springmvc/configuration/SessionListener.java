package com.websystique.springmvc.configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.websystique.springmvc.model.Global;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("==== Session is created ====");
if(event.getSession().getAttribute("loggedinuser")!=null){
	
	Global.increaseCount();
}
		event.getSession().setMaxInactiveInterval(60 * 10);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		Global.decreaseCount();
		System.out.println("==== Session is destroyed ====");
	}
}
