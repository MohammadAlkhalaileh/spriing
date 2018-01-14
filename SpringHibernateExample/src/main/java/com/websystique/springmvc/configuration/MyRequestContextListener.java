package com.websystique.springmvc.configuration;

import javax.servlet.annotation.WebListener;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
@WebListener
public class MyRequestContextListener extends RequestContextListener {

	// this listener was added to allow the CustomAuthenticationSuccessHandler inject a session bean
	
}