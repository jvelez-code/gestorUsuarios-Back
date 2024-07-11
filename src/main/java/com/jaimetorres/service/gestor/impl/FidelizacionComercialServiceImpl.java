package com.jaimetorres.service.gestor.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.FidelizacionComercial;
import com.jaimetorres.repo.gestor.IFidelizacionComercialRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.gestor.IFidelizacionComercialService;

@Service
public class FidelizacionComercialServiceImpl extends CRUDImpl<FidelizacionComercial, Integer> implements IFidelizacionComercialService {

	@Autowired
	private IFidelizacionComercialRepo repo;
	
	@Override
	protected IGenericRepo<FidelizacionComercial, Integer> getRepo(){
		return repo;
	}

	@Override
	public List<FidelizacionComercial> buscarFidelizacionS(ParametrosDTO filtro) {
		return repo.buscarFidelizacionR(filtro.getFechaInicial(),filtro.getFechaFinal());
	}

	
	}


