package com.jaimetorres;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "contactEntityManagerFactory", transactionManagerRef = "contactTransactionManager", 
basePackages = { "com.jaimetorres.repo.contact" })
public class ContactConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name = "contactDataSource")
	public DataSource contactDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("contact.datasource.url"));
		dataSource.setUsername(env.getProperty("contact.datasource.username"));
		dataSource.setPassword(env.getProperty("contact.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("contact.datasource.driver-class-name"));
		
		return dataSource;
	}
	

	@Primary
	@Bean(name = "contactEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(contactDatasource());
		em.setPackagesToScan("com.jaimetorres.model.contact");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("contact.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.show-sql", env.getProperty("contact.jpa.show-sql"));
		properties.put("hibernate.dialect", env.getProperty("contact.jpa.database-platform"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
		
	}
	
	@Primary
	@Bean(name = "contactTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}