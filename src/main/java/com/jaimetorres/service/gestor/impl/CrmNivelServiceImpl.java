package com.jaimetorres.service.gestor.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.CrmNivel;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmNivelService;

@Service
public class CrmNivelServiceImpl extends CRUDImpl<CrmNivel, Integer> implements ICrmNivelService {

	@Autowired
	private ICrmNivelRepo repo;
	
	@Override
	protected IGenericRepo<CrmNivel, Integer> getRepo(){
		return repo;
	}
	
}


