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
@EnableJpaRepositories(entityManagerFactoryRef = "gestorEntityManagerFactory", transactionManagerRef = "gestorTransactionManager", 
basePackages = { "com.jaimetorres.repo.gestor" })
public class GestorConfig {
	
	@Autowired
	private Environment env;
	
	@Value("${gestor.datasource.password}")
    private String encryptedPassword;

    @Value("${encryption.secret.key}")
    private String base64SecretKey;
	
	
	
	@SuppressWarnings("null")
	@Bean(name = "gestorDataSource")
	public DataSource gestorDatasource() throws Exception {
		String decryptedPassword = decryptPassword(encryptedPassword, base64SecretKey);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("gestor.datasource.url"));
		dataSource.setUsername(env.getProperty("gestor.datasource.username"));
		dataSource.setPassword(decryptedPassword);
		//config.setPassword(decryptedPassword);
		dataSource.setDriverClassName(env.getProperty("gestor.datasource.driver-class-name"));		
		return dataSource;

		    // String decryptedPassword = decryptPassword(encryptedPassword, base64SecretKey);
		    // HikariConfig config = new HikariConfig();
	        // config.setJdbcUrl(env.getProperty("gestor.datasource.url"));
	        // config.setUsername(env.getProperty("gestor.datasource.username"));
	        // //config.setPassword(env.getProperty("V3l3z2024*"));
	        // config.setPassword(decryptedPassword);
	        // //System.out.print(decryptedPassword);
	        // config.setDriverClassName(env.getProperty("gestor.datasource.driver-class-name"));
	        
	        
	        
	        // // Configuración del pool de conexiones a través de propiedades en application.properties
	        // config.setMaximumPoolSize(Integer.parseInt(env.getProperty("gestor.datasource.hikari.maximum-pool-size")));
	        // config.setMinimumIdle(Integer.parseInt(env.getProperty("gestor.datasource.hikari.minimum-idle")));
	        // config.setIdleTimeout(Long.parseLong(env.getProperty("gestor.datasource.hikari.idle-timeout")));
	        // config.setConnectionTimeout(Long.parseLong(env.getProperty("gestor.datasource.hikari.connection-timeout")));
	        // config.setMaxLifetime(Long.parseLong(env.getProperty("gestor.datasource.hikari.max-lifetime")));
	        
	        // return new HikariDataSource(config);
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
	@Bean(name = "gestorEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
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
	public PlatformTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}