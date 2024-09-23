package com.jaimetorres.service.gestor.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jaimetorres.model.gestor.Campana;
import com.jaimetorres.repo.gestor.ICampanaRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.gestor.ICampanaService;

@Service
public class CampanaServiceImpl extends CRUDImpl<Campana, Integer> implements ICampanaService {

	@Autowired
	private ICampanaRepo repo;
	
	@Override
	protected IGenericRepo<Campana, Integer> getRepo(){
		return repo;
	}
			
}


