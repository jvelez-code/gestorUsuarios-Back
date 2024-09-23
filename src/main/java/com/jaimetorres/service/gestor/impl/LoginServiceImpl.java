package com.jaimetorres.service.gestor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jaimetorres.model.gestor.Usuarios;
import com.jaimetorres.repo.gestor.ILoginRepo;
import com.jaimetorres.service.gestor.ILoginService;


@Service
public class LoginServiceImpl implements ILoginService{
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;	
	
	@Autowired
	private ILoginRepo repo;

	@Override
	public Usuarios verificarNombreUsuario(String email) {
		return repo.verificarNombreUsuario(email);
	}

	@Override
	public void cambiarClave(String clave, String nombre) {
		repo.cambiarClave(bcrypt.encode(clave), nombre);
	}

	@Override
	public void cambiarIntento(String nombre) {
		repo.cambiarIntento(nombre);		
	}
	
	

}
