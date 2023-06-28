package com.jaimetorres;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jaimetorres.model.gestor.Usuarios;
import com.jaimetorres.repo.gestor.IUsuariosRepo;

@SpringBootTest
class GestorUsuariosBackApplicationTests {

	@Autowired
	private IUsuariosRepo repo;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Test
	void verificarClave() {
		Date fechacambio= new Date (12345678800000L);
		
		
		Usuarios us = new Usuarios();
	us.setUsername("jaime5");
		us.setPassword(bcrypt.encode("123"));				
		us.setEnabled(true);
		us.setEmail("pruebas5@cosm.co");
		us.setFechaCambio(fechacambio);
		
		Usuarios retorno = repo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));		
		
		//prueba de la clase equivalente, la universidad politecnica de valencia 
	}


}
