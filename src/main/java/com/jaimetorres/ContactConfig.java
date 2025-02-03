package com.jaimetorres;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "contactEntityManagerFactory", transactionManagerRef = "contactTransactionManager", 
basePackages = { "com.jaimetorres.repo.contact" })
public class ContactConfig {

	@Autowired
	private Environment env;

	@Value("${contact.datasource.password}")
	private String encryptedPassword;

	@Value("${encryption.secret.key}")
	private String base64SecretKey;

	@Bean(name = "contactDataSource")
	public DataSource contactDatasource() throws Exception {
		//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//		dataSource.setUrl(env.getProperty("contact.datasource.url"));
		//		dataSource.setUsername(env.getProperty("contact.datasource.username"));
		//		dataSource.setPassword(env.getProperty("contact.datasource.password"));
		//		dataSource.setDriverClassName(env.getProperty("contact.datasource.driver-class-name"));		
		//		return dataSource;
		String decryptedPassword = decryptPassword(encryptedPassword, base64SecretKey);
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(env.getProperty("contact.datasource.url"));
		config.setUsername(env.getProperty("contact.datasource.username"));
		//config.setPassword(env.getProperty("contact.datasource.password"));
		config.setPassword(decryptedPassword);
		config.setDriverClassName(env.getProperty("contact.datasource.driver-class-name"));

		// Configuración del pool de conexiones a través de propiedades en application.properties
		config.setMaximumPoolSize(Integer.parseInt(env.getProperty("contact.datasource.hikari.maximum-pool-size")));
		config.setMinimumIdle(Integer.parseInt(env.getProperty("contact.datasource.hikari.minimum-idle")));
		config.setIdleTimeout(Long.parseLong(env.getProperty("contact.datasource.hikari.idle-timeout")));
		config.setConnectionTimeout(Long.parseLong(env.getProperty("contact.datasource.hikari.connection-timeout")));
		config.setMaxLifetime(Long.parseLong(env.getProperty("contact.datasource.hikari.max-lifetime")));

		return new HikariDataSource(config);
	}

	private String decryptPassword(String encryptedPassword, String base64Key) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(base64Key);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, keySpec);
		byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
		byte[] decryptedBytes = cipher.doFinal(decodedBytes);
		return new String(decryptedBytes);
	}

	@Primary
	@Bean(name = "contactEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
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
	public PlatformTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}
}