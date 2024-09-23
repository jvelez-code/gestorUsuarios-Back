package com.jaimetorres.service.gestor.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.CrmFuente;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmFuenteService;

@Service
public class CrmFuenteServiceImpl extends CRUDImpl<CrmFuente, Integer> implements ICrmFuenteService {

	@Autowired
	private ICrmFuenteRepo repo;
	
	@Override
	protected IGenericRepo<CrmFuente, Integer> getRepo(){
		return repo;
	}
	
}


