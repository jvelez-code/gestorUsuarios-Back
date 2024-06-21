package com.jaimetorres.service.gestor.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.CrmTipologia;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmTipologiaService;

@Service
public class CrmTipologiaServiceImpl extends CRUDImpl<CrmTipologia, Integer> implements ICrmTipologiaService {

	@Autowired
	private ICrmTipologiaRepo repo;
	
	@Override
	protected IGenericRepo<CrmTipologia, Integer> getRepo(){
		return repo;
	}

	@Override
	public List<CrmTipologia> buscarTipoS(Integer id) {
		return repo.buscarTipoR(id);
	}
	
}


