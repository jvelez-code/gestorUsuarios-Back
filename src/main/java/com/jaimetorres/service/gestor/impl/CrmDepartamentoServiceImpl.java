package com.jaimetorres.service.gestor.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.CrmDepartamento;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmDepartamentoService;

@Service
public class CrmDepartamentoServiceImpl extends CRUDImpl<CrmDepartamento, Integer> implements ICrmDepartamentoService {

	@Autowired
	private ICrmDepartamentoRepo repo;
	
	@Override
	protected IGenericRepo<CrmDepartamento, Integer> getRepo(){
		return repo;
	}
	
}


