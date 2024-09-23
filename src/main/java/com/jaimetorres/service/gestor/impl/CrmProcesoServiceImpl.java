package com.jaimetorres.service.gestor.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.CrmProceso;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmProcesoService;

@Service
public class CrmProcesoServiceImpl extends CRUDImpl<CrmProceso, Integer> implements ICrmProcesoService {

	@Autowired
	private ICrmProcesoRepo repo;
	
	@Override
	protected IGenericRepo<CrmProceso, Integer> getRepo(){
		return repo;
	}
	
}


