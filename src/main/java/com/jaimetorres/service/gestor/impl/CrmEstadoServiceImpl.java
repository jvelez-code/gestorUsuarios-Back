package com.jaimetorres.service.gestor.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.CrmEstado;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmEstadoService;

@Service
public class CrmEstadoServiceImpl extends CRUDImpl<CrmEstado, Integer> implements ICrmEstadoService {

	@Autowired
	private ICrmEstadoRepo repo;
	
	@Override
	protected IGenericRepo<CrmEstado, Integer> getRepo(){
		return repo;
	}
	
}


