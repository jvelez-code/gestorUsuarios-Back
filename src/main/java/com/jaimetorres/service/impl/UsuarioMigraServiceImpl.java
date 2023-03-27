package com.jaimetorres.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.contact.UsuarioMigra;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.repo.contact.IusuarioMigraRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.IUsuarioMigraService;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;

@Service
public class UsuarioMigraServiceImpl extends CRUDImpl<UsuarioMigra, Integer> implements IUsuarioMigraService {

	@Autowired
	private IusuarioMigraRepo repo;

	@Override
	protected IGenericRepo<UsuarioMigra, Integer> getRepo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	}


