package com.jaimetorres.service.gestor.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.Festivo;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.IFestivoService;

@Service
public class FestivoServiceImpl extends CRUDImpl<Festivo, Integer> implements IFestivoService {

	@Autowired
	private IFestivoRepo repo;
	
	@Override
	protected IGenericRepo<Festivo, Integer> getRepo(){
		return repo;
	}	
	
}


