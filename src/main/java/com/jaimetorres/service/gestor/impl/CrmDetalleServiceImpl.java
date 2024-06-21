package com.jaimetorres.service.gestor.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.CrmDetalle;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmDetalleService;

@Service
public class CrmDetalleServiceImpl extends CRUDImpl<CrmDetalle, Integer> implements ICrmDetalleService {

	@Autowired
	private ICrmDetalleRepo repo;
	
	@Override
	protected IGenericRepo<CrmDetalle, Integer> getRepo(){
		return repo;
	}

	@Override
	public List<CrmDetalle> buscarDetalleS(Integer id) {
		return repo.buscarDetalleR(id);
	}
	
}


