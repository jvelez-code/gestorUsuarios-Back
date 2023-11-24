package com.jaimetorres.service.gestor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.CicloDeVida;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
import com.jaimetorres.service.gestor.ICicloDeVidaService;

@Service
public class CIcloDeVidaServiceImpl extends CRUDImpl<CicloDeVida, Integer> implements ICicloDeVidaService {

	@Autowired
	private ICicloDeVidaRepo repo;
	
	@Override
	protected IGenericRepo<CicloDeVida, Integer> getRepo(){
		return repo;
	}

	@Override
	public void actualizaCiclo(ParametrosDTO filtro) {
		
		repo.modificar(filtro.getIdDetalleComer(), filtro.getCicloVida());		
	}
	

}


