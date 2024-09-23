package com.jaimetorres.service.gestor.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroCrmDetallesDTO;
import com.jaimetorres.model.gestor.CrmCategoria;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmCategoriaService;

@Service
public class CrmCategoriaServiceImpl extends CRUDImpl<CrmCategoria, Integer> implements ICrmCategoriaService {

	@Autowired
	private ICrmCategoriaRepo repo;
	
	@Override
	protected IGenericRepo<CrmCategoria, Integer> getRepo(){
		return repo;
	}

	@Override
	public CrmCategoria diasVencimiento(FiltroCrmDetallesDTO filtro) {
			return repo.buscarVenci(filtro.getIdCategoria());
	}
	
}


