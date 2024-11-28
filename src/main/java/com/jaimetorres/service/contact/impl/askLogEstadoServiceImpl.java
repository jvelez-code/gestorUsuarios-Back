package com.jaimetorres.service.contact.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.FiltroEstadoDTO;
import com.jaimetorres.model.contact.AskEstado;
import com.jaimetorres.model.contact.AskEstadoExtension;
import com.jaimetorres.model.contact.AskLogEstado;
import com.jaimetorres.repo.contact.IGenericContactRepo;
import com.jaimetorres.repo.contact.IAskEstadoExtensionRepo;
import com.jaimetorres.repo.contact.IAskLogEstadoRepo;
import com.jaimetorres.service.contact.IAskLogEstadoService;

@Service
public class askLogEstadoServiceImpl extends CRUDContactImpl<AskLogEstado, Integer> implements IAskLogEstadoService {

	@Autowired
	private IAskLogEstadoRepo repo;

	@Override
	protected IGenericContactRepo<AskLogEstado, Integer> getRepo() {
				return repo;
	}

	@Override
	public Integer buscarExt(FiltroEstadoDTO filtro) {
		Integer idExt =repo.buscar(filtro.getIdExtension());
		return (idExt != null && idExt > 0) ? idExt : 0;
		
		
	}

	@Override
	public void actualizarExt(Integer idLog) {
		repo.actualizarEstado(idLog);
		
	}

	@Override
	public void registrarExt(FiltroEstadoDTO filtro) {
		
		repo.registrar(filtro.getIdExtension(), filtro.getEstadoAsk());
		
	}

	@Override
	public void registrarExtNue(FiltroEstadoDTO filtro) {
		repo.registrarNuevo(filtro.getIdExtension(), filtro.getEstadoAsk());
		
	}

	
}
