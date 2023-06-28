package com.jaimetorres.service.gestor.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.Usuario;
import com.jaimetorres.model.gestor.Usuarios;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
import com.jaimetorres.service.gestor.IUsuarioService;

@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService {

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	protected IGenericRepo<Usuario, Integer> getRepo(){
		return repo;
	}

	@Override
	public Usuario buscar(FiltroEntranteDTO filtro) {
		return repo.buscarUsuario(filtro.getLoginAgente());
	}

	@Override
	public void cerrarSesion(FiltroEntranteDTO filtro) {
		repo.cerrarSesion(filtro.getLoginAgente());
		System.out.print("Hola mundo");
	}

	@Override
	public Usuarios buscarLogin(FiltroEntranteDTO filtro) {
		return repo.buscarUsuarios(filtro.getLoginAgente());
	}
	
	
}


