package com.websystique.springmvc.configuration;

import java.util.EnumSet;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Notice that above initializer class extends AbstractAnnotationConfigDispatcherServletInitializer which is the base class for 
 * all WebApplicationInitializer implementations. Implementations of WebApplicationInitializer configures ServletContext programatically,
 * for Servlet 3.0 environments. It means we won’t be using web.xml and we will deploy the app on Servlet 3.0 container.
 * */

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new HiddenHttpMethodFilter() };
	}


	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.addListener(new MyRequestContextListener());
		servletContext.addListener(new SessionListener());
		servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
	}

}
