package com.websystique.springmvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * Author: Ahmed AlSarie
 * Date: 08/07/2017
 * Description: This configuration creates a Servlet Filter known as the springSecurityFilterChain which is responsible for
			 *  all the security (protecting the application URLs, validating submitted username and passwords, redirecting to the log in form, etc) 
			 *  within our application.
 * */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	PersistentTokenRepository tokenRepository;


    @Autowired
    CustomSuccessHandler customSuccessHandler;
	/**
	 * Method configureGlobalSecurity in above class configures AuthenticationManagerBuilder with user credentials and allowed roles.
	 * This AuthenticationManagerBuilder creates AuthenticationManager which is responsible for processing any authentication request.
	 * Notice that in above example, we have used JDBC authentication while you are free to choose from in memory, LDAP and other authentications
	 * */
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	/**
	 * The overridden Method Configure configures HttpSecurity which allows configuring web based security for specific http requests.
	 * By default it will be applied to all requests, but can be restricted using requestMatcher(RequestMatcher)/antMathchers 
	 * or other similar methods.
	 * 
	 * /department/departments-form
	 * /employee/employees-form
	 * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/", "/index").permitAll()//.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
		 .antMatchers("/department/departments-form").access("hasRole('ViewDept') or hasRole('AddDept')")
		 .antMatchers("/employee//employees-form").access("hasRole('ViewEmp') or hasRole('AddEmp')")		 
		 .antMatchers("/department/edit-**").access("hasRole('UpdateDept')")
		 .antMatchers("/employee/edit-**").access("hasRole('UpdateEmp')")
		 .antMatchers("/department/delete-**").access("hasRole('DeleteDept')")
		 .antMatchers("/employee/delete-**").access("hasRole('DeleteEmp')")
		 .antMatchers("/department/DepartmentsEmployeesCountReport").access("hasRole('DepartmentsEmployeesCountReport')")
		 .antMatchers("/department/DepartmentsEmployeesSummaryReport").access("hasRole('DepartmentsEmployeesSummaryReport')")
		 .antMatchers("/employee/EmployeesSalariesSummary").access("hasRole('EmployeesSalariesSummary')")
		 .antMatchers("/employee/SumOfSalaryInCity").access("hasRole('SumOfSalaryInCity')")
		 .antMatchers("/employee/EmployeesMaritalStatus").access("hasRole('EmployeesMaritalStatus')")
		 .antMatchers("/employee/TotalSalaryInDepartment").access("hasRole('TotalSalaryInDepartment')")
		 
		 .and().formLogin().loginPage("/login2").loginProcessingUrl("/login2").successHandler(customSuccessHandler)
		 .usernameParameter("ssoId").passwordParameter("password")
		 .and().rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
		 .tokenValiditySeconds(86400).and().csrf().and().exceptionHandling().accessDeniedPage("/Access_Denied");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
				"remember-me", userDetailsService, tokenRepository);
		return tokenBasedservice;
	}

	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}

}
