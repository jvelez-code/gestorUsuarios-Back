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
@EnableJpaRepositories(entityManagerFactoryRef = "gestorEntityManagerFactory", transactionManagerRef = "gestorTransactionManager", 
basePackages = { "com.jaimetorres.repo.gestor" })
public class GestorConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name = "gestorDataSource")
	public DataSource gestorDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("gestor.datasource.url"));
		dataSource.setUsername(env.getProperty("gestor.datasource.username"));
		dataSource.setPassword(env.getProperty("gestor.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("gestor.datasource.driver-class-name"));
		
		return dataSource;
	}
	

	@Primary
	@Bean(name = "gestorEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(gestorDatasource());
		em.setPackagesToScan("com.jaimetorres.model.gestor");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("gestor.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.show-sql", env.getProperty("gestor.jpa.show-sql"));
		properties.put("hibernate.dialect", env.getProperty("gestor.jpa.database-platform"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
		
	}
	
	@Primary
	@Bean(name = "gestorTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}