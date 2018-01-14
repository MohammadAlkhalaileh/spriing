package com.websystique.springmvc.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.websystique.springmvc.data.repo" })
@ComponentScan({ "com.websystique.springmvc.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

	@Autowired
	Environment env;

	// @Autowired
	// private Environment environment;

	// @Bean
	// LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource
	// dataSource, Environment env) {
	// LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new
	// LocalContainerEntityManagerFactoryBean();
	// entityManagerFactoryBean.setDataSource(dataSource);
	// entityManagerFactoryBean.setJpaVendorAdapter(new
	// HibernateJpaVendorAdapter());
	// entityManagerFactoryBean.setPackagesToScan("com.websystique.springmvc.model");
	//
	// Properties jpaProperties = new Properties();
	//
	// //Configures the used database dialect. This allows Hibernate to create
	// SQL
	// //that is optimized for the used database.
	// jpaProperties.put("hibernate.dialect",
	// env.getRequiredProperty("hibernate.dialect"));
	//
	// //Specifies the action that is invoked to the database when the Hibernate
	// //SessionFactory is created or closed.
	// jpaProperties.put("hibernate.hbm2ddl.auto",
	// env.getRequiredProperty("hibernate.hbm2ddl.auto")
	// );
	//
	// //Configures the naming strategy that is used when Hibernate creates
	// //new database objects and schema elements
	// jpaProperties.put("hibernate.ejb.naming_strategy",
	// env.getRequiredProperty("hibernate.ejb.naming_strategy")
	// );
	//
	// //If the value of this property is true, Hibernate writes all SQL
	// //statements to the console.
	// jpaProperties.put("hibernate.show_sql",
	// env.getRequiredProperty("hibernate.show_sql")
	// );
	//
	// //If the value of this property is true, Hibernate will format the SQL
	// //that is written to the console.
	// jpaProperties.put("hibernate.format_sql",
	// env.getRequiredProperty("hibernate.format_sql")
	// );
	//
	// entityManagerFactoryBean.setJpaProperties(jpaProperties);
	//
	// return entityManagerFactoryBean;
	// }
	 @Bean
	 public LocalSessionFactoryBean sessionFactory() {
	 LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	 sessionFactory.setDataSource(dataSource());
	 sessionFactory.setPackagesToScan(new String[] {
	 "com.websystique.springmvc.model" });
	 sessionFactory.setHibernateProperties(hibernateProperties());
	 return sessionFactory;
	 }
	//
//	 @Bean
//	 public DataSource dataSource() {
//	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	 dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//	 dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//	 dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
//	 dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
//	 return dataSource;
//	 }
	//
	 private Properties hibernateProperties() {
	 Properties properties = new Properties();
//	 properties.put("hibernate.dialect",
//	 environment.getRequiredProperty("hibernate.dialect"));
//	 properties.put("hibernate.show_sql",
//	 environment.getRequiredProperty("hibernate.show_sql"));
//	 properties.put("hibernate.format_sql",
//	 environment.getRequiredProperty("hibernate.format_sql"));
	 properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
     properties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
	 return properties;
	 }

	// @Bean
	// @Autowired
	// public HibernateTransactionManager transactionManager(SessionFactory s) {
	// HibernateTransactionManager txManager = new
	// HibernateTransactionManager();
	// txManager.setSessionFactory(s);
	// return txManager;
	// }

	@Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "com.websystique.springmvc.model" });
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());
	 
	      return em;
	   }
	 
	   @Bean
	   public DataSource dataSource(){
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
	 	 dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
	 	 dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
	 	 dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
	 	 return dataSource;
	   }
	 
	   @Bean
	   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	 
	      return transactionManager;
	   }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	   Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
	      properties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
	      return properties;
	   }

}
