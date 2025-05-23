package com.jaimetorres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;

//Segunda Clase
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Autowired
    private ResourceServerTokenServices tokenServices;
		
    @Value("${security.jwt.resource-ids}")
    private String resourceIds;
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
	    	   http
	           .exceptionHandling()
	               .authenticationEntryPoint(authenticationEntryPoint())
	           .and()
	           .headers()
	               .contentSecurityPolicy("default-src 'self'")
	               .and()
	               .xssProtection()
	                   .xssProtectionEnabled(true)
	               .and()
	               .cacheControl()
	               .and()
	               .frameOptions()
	                   .deny()
	           .and()
                .authorizeRequests()
                .antMatchers("/oauth/token", "/apijavabackend/oauth/token").permitAll()
                .antMatchers("/apijavabackend/v2/api-docs/**" ).permitAll()
                .antMatchers("/apijavabackend/v3/api-docs/**" ).permitAll()
                //.antMatchers("/apijavabackend/tipoDocumentos/**" ).authenticated() 
                .antMatchers("/apijavabackend/askEstados/**" ).authenticated()
                .antMatchers("/apijavabackend/LlamadasEntrantes/**" ).authenticated()                
                .antMatchers("/apijavabackend/askEstadoExtensiones/**" ).authenticated()
                .antMatchers("/apijavabackend/clientes/**" ).authenticated()
                .antMatchers("/apijavabackend/contactos/**" ).authenticated()
                .antMatchers("/apijavabackend/detallegestiones/**" ).authenticated()
                .antMatchers("/apijavabackend/estadoGestiones/**" ).authenticated()
                .antMatchers("/apijavabackend/crmCasos/**" ).authenticated()
                .antMatchers("/apijavabackend/usuarios/**" ).permitAll()
                .antMatchers("/apijavabackend/productividad/**" ).authenticated()
                .antMatchers("/apijavabackend/tokens/anular/**" ).permitAll()
                .antMatchers("/apijavabackend/campanas/**" ).permitAll();
                //.antMatchers("/apijavabackend/tokens/**" ).authenticated();     
                //.antMatchers("/apijavabackend/oauth/token/**" ).authenticated();
                
    }    
    
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthException(); // Usa tu implementación personalizada de AuthenticationEntryPoint
    }
}
