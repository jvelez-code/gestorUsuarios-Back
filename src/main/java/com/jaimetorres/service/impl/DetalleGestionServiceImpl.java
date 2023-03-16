package com.jaimetorres.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.DetalleGestion;
import com.jaimetorres.repo.IDetalleGestionRepo;
import com.jaimetorres.repo.IGenericRepo;
import com.jaimetorres.service.IDetalleGestionService;

@Service
public class DetalleGestionServiceImpl extends CRUDImpl<DetalleGestion, Integer> implements IDetalleGestionService {

	@Autowired
	private IDetalleGestionRepo repo;
	
	@Override
	protected IGenericRepo<DetalleGestion, Integer> getRepo(){
		return repo;
	}


	@Override
	public List<DetalleGestion> buscarHisto(FiltroEntranteDTO filtro) {
		return repo.buscar(filtro.getIdCliente());
	}
	
	
}