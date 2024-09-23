package com.jaimetorres.service.gestor.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.CrmOrigen;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmOrigenService;

@Service
public class CrmOrigenServiceImpl extends CRUDImpl<CrmOrigen, Integer> implements ICrmOrigenService {

	@Autowired
	private ICrmOrigenRepo repo;
	
	@Override
	protected IGenericRepo<CrmOrigen, Integer> getRepo(){
		return repo;
	}
	
}


