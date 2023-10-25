package com.jaimetorres.service.contact.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.FiltroEstadoDTO;
import com.jaimetorres.model.contact.AskEstadoExtension;
import com.jaimetorres.repo.contact.IGenericContactRepo;
import com.jaimetorres.repo.contact.IAskEstadoExtensionRepo;
import com.jaimetorres.service.contact.IAskEstadoExtensionService;

@Service
public class askEstadoExtensionServiceImpl extends CRUDContactImpl<AskEstadoExtension, Integer> implements IAskEstadoExtensionService {

	@Autowired
	private IAskEstadoExtensionRepo repo;

	@Override
	protected IGenericContactRepo<AskEstadoExtension, Integer> getRepo() {
		
		return repo;
	}

	@Override
	public AskEstadoExtension buscar(ParametrosDTO filtro) {
		return repo.buscar(filtro.getNroDocumento());
	}

	@Override
	public AskEstadoExtension buscarAgente(ParametrosDTO filtro) {
		return repo.buscarAgente(filtro.getLoginAgente());
	}

	@Override
	public void cambioEstado(FiltroEstadoDTO filtro) {
		repo.actualizarEstado(filtro.getEstadoAsk(), filtro.getLoginAgente());
	}

	
	
	

}
