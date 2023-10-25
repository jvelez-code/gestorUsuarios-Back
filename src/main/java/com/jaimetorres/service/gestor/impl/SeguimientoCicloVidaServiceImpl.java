package com.jaimetorres.service.gestor.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.SeguimientoCicloVida;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ISeguimientoCicloVidaService;

@Service
public class SeguimientoCicloVidaServiceImpl extends CRUDImpl<SeguimientoCicloVida, Integer> implements ISeguimientoCicloVidaService {

	@Autowired
	private ISeguimientoCicloVidaRepo repo;
	
	@Override
	protected IGenericRepo<SeguimientoCicloVida, Integer> getRepo(){
		return repo;
	}}


