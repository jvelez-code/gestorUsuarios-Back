package com.jaimetorres.service.contact.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.dto.FiltroEstadoDTO;
import com.jaimetorres.model.contact.LlamadaEntrante;
import com.jaimetorres.repo.contact.IGenericContactRepo;
import com.jaimetorres.repo.contact.ILlamadaEntranteRepo;
import com.jaimetorres.service.contact.ILlamadaEntranteService;

@Service
public class LlamadaEntranteServiceImpl extends CRUDContactImpl<LlamadaEntrante, Integer> implements ILlamadaEntranteService {

	@Autowired
	private ILlamadaEntranteRepo repo;

	@Override
	protected IGenericContactRepo<LlamadaEntrante, Integer> getRepo() {
		
		return repo;
	}

	@Override
	public LlamadaEntrante buscarIdAsterisk(FiltroEntranteDTO filtro) {
		return repo.buscarIdAsterisk(filtro.getNroDocumento());
	}

	@Override
	public String validarAsterisk(FiltroEntranteDTO filtro) {
		return repo.validarAsterisk(filtro.getNroDocumento());
	}

	

	

	
	
	

}
