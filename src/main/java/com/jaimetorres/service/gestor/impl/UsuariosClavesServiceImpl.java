package com.jaimetorres.service.gestor.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.UsuariosClaves;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.repo.gestor.IUsuariosClavesRepo;
import com.jaimetorres.service.gestor.IUsuariosClavesService;

@Service
public class UsuariosClavesServiceImpl extends CRUDImpl<UsuariosClaves, Integer> implements IUsuariosClavesService {

	@Autowired
	private IUsuariosClavesRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;	
	
	@Override
	protected IGenericRepo<UsuariosClaves, Integer> getRepo(){
		return repo;
	}

	@Override
	public boolean buscarClaves(ParametrosDTO filtro) {
		List<UsuariosClaves> usuarios = repo.buscarClaves(filtro.getIdUsuario());
		String clave= filtro.getPassword();
		for(UsuariosClaves usuario :usuarios) {
					
			if (bcrypt.matches(clave, usuario.getPassword())) {
                return true;
            }
		}
		return false;
		
	}

	
	
}
		
	
		
		
	


	
	



