package com.jaimetorres.service.gestor.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.SeguimientoComercial;
import com.jaimetorres.repo.gestor.ISeguimientoComercialRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.gestor.ISeguimientoComercialService;

@Service
public class SeguimientoComercialServiceImpl extends CRUDImpl<SeguimientoComercial, Integer> implements ISeguimientoComercialService {

	@Autowired
	private ISeguimientoComercialRepo repo;
	
	@Override
	protected IGenericRepo<SeguimientoComercial, Integer> getRepo(){
		return repo;
	}


}


