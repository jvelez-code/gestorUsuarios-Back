package com.jaimetorres.service.gestor.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.CrmSubCategoria;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmSubCategoriaService;

@Service
public class CrmSubCategoriaServiceImpl extends CRUDImpl<CrmSubCategoria, Integer> implements ICrmSubCategoriaService {

	@Autowired
	private ICrmSubCategoriaRepo repo;
	
	@Override
	protected IGenericRepo<CrmSubCategoria, Integer> getRepo(){
		return repo;
	}

	@Override
	public List<CrmSubCategoria> buscarSubcateS(Integer id) {
		return repo.buscarSubcateR(id);
	}
	
}


