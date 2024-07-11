package com.jaimetorres.service.gestor.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.estadoComercialDto;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.EstadoGestion;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
import com.jaimetorres.service.gestor.IEstadoGestionService;
@Service
public class EstadoGestionServiceImpl extends CRUDImpl<EstadoGestion, Integer> implements IEstadoGestionService {

	@Autowired
	private IEstadoGestionRepo repo;
	
	@Override
	protected IGenericRepo<EstadoGestion, Integer> getRepo(){
		return repo;
	}
	
	@Override
	public List<EstadoGestion> buscar(ParametrosDTO filtro) {
		
		return repo.buscarEstadoP(filtro.getIdEmpresa(),  filtro.getTipoLlamada());
		
	}

	@Override
	public List<EstadoGestion> buscarEstadoH(ParametrosDTO filtro) {
		return repo.buscarEstadoH(filtro.getIdEstadoPadre());
	}

	@Override
	public List<estadoComercialDto> gestionComercial(ParametrosDTO filtro) {
		//return repo.estadoComercial(filtro.getIdEmpresa());
		List<estadoComercialDto> gestionComercial= new ArrayList<>();
		repo.estadoComercial(filtro.getIdEmpresa()).forEach(x -> {
			estadoComercialDto m = new estadoComercialDto();
			m.setIdEstadoGestion((Integer) x[0]);
			m.setNombre(String.valueOf(x[1]));
			gestionComercial.add(m);
		});
		
		return gestionComercial;
	}

	@Override
	public List<EstadoGestion> buscarSecretaria(ParametrosDTO filtro) {
		return repo.buscarSecretaria(filtro.getIdEmpresa());
	}




		
}


