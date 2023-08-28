package com.jaimetorres.service.gestor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.Empresa;
import com.jaimetorres.repo.gestor.IEmpresaRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.gestor.IEmpresaService;


@Service
public class EmpresaServiceImpl extends CRUDImpl<Empresa, Integer> implements IEmpresaService {

	@Autowired
	private IEmpresaRepo repo;
	
	@Override
	protected IGenericRepo<Empresa, Integer> getRepo(){
		return repo;
	}

	@Override
	public void modificar(FiltroEntranteDTO filtro) {
		repo.modificar(filtro.getIdEmpresa(), filtro.getLoginAgente());		
	}
	
	}


