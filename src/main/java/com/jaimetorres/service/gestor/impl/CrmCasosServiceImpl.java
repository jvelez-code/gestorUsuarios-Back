package com.jaimetorres.service.gestor.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.CrmCasos;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmCasosService;

@Service
public class CrmCasosServiceImpl extends CRUDImpl<CrmCasos, Integer> implements ICrmCasosService {

	@Autowired
	private ICrmCasosRepo repo;
	
	@Override
	protected IGenericRepo<CrmCasos, Integer> getRepo(){
		return repo;
	}

	@Override
	public List<CrmCasos> buscarCasosS(ParametrosDTO filtro) {
		return repo.buscarCasosR(filtro.getIdCliente());
	}

	@Override
	public List<CrmCasos> buscarEstadoR() {
		return repo.buscarEstadoR();
	}

	@Override
	public void actuEstadoR(ParametrosDTO filtro) {
		repo.actuEstado(filtro.getIdCrmEstado(), filtro.getIdCrmCaso());
	}

	
}


