package com.jaimetorres.service.gestor.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.Rol;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.IRolService;

@Service
public class RolServiceImpl extends CRUDImpl<Rol, Integer> implements IRolService {

	@Autowired
	private IRolRepo repo;
	
	@Override
	protected IGenericRepo<Rol, Integer> getRepo(){
		return repo;
	}
	
}


