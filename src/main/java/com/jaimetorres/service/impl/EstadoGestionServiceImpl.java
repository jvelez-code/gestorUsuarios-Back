package com.jaimetorres.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.DetalleGestion;
import com.jaimetorres.model.EstadoGestion;
import com.jaimetorres.model.EstadoGestion;
import com.jaimetorres.repo.IEstadoGestionRepo;
import com.jaimetorres.repo.IGenericRepo;
import com.jaimetorres.service.IEstadoGestionService;

@Service
public class EstadoGestionServiceImpl extends CRUDImpl<EstadoGestion, Integer> implements IEstadoGestionService {

	@Autowired
	private IEstadoGestionRepo repo;
	
	@Override
	protected IGenericRepo<EstadoGestion, Integer> getRepo(){
		return repo;
	}
	
	@Override
	public List<EstadoGestion> buscar(FiltroEntranteDTO filtro) {
		
		return repo.buscarEstadoP(filtro.getIdEmpresa(),  filtro.getIdTipoCampana());
		
	}

	@Override
	public List<EstadoGestion> buscarEstadoH(FiltroEntranteDTO filtro) {
		System.out.print("Hola mundo");
		return repo.buscarEstadoH(filtro.getIdEstadoPadre());
	}




		
}


