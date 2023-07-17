package com.jaimetorres.service.gestor.impl;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.CantidadGestionDto;
import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.dto.tmoGestionDto;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.model.gestor.Menu;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
import com.jaimetorres.service.gestor.IDetalleGestionService;

@Service
public class DetalleGestionServiceImpl extends CRUDImpl<DetalleGestion, Integer> implements IDetalleGestionService {

	@Autowired
	private IDetalleGestionRepo repo;
	
	@Override
	protected IGenericRepo<DetalleGestion, Integer> getRepo(){
		return repo;
	}

	@Override
	public List<FiltroDetalleGestionDTO> buscarM(FiltroEntranteDTO filtro) {
		
		List<FiltroDetalleGestionDTO> detalle = new ArrayList<>();
		repo.buscarM(filtro.getIdCliente()).forEach(x -> {
			FiltroDetalleGestionDTO m = new FiltroDetalleGestionDTO();
			m.setFecha(String.valueOf(x[0]));
			m.setUsuario(String.valueOf(x[1]));
			m.setCampana(String.valueOf(x[2]));
			m.setTipo(String.valueOf(x[3]));
			m.setSubtipo(String.valueOf(x[4]));
			m.setObservacion(String.valueOf(x[5]));
			m.setNumero(String.valueOf(x[6]));
			
			detalle.add(m);
		});
		return detalle;
		
		//return repo.buscarM(filtro.getIdCliente());
	}

	@Override
	public List<Gestion> buscarHisto(FiltroEntranteDTO filtro) {
		// TODO Auto-generated method stub
		return repo.buscar(filtro.getIdCliente());
	}

	@Override
	public List<CantidadGestionDto> cantidadGestion(FiltroEntranteDTO filtro) {
		List<CantidadGestionDto> detalle = new ArrayList<>();
		repo.cantidadGestion(filtro.getLoginAgente()).forEach(x -> {
			CantidadGestionDto m = new CantidadGestionDto();
			m.setUsuario(String.valueOf(x[0]));
			m.setEfectiva(String.valueOf(x[1]));
			m.setCantidad(String.valueOf(x[2]));
			detalle.add(m);
		});
		return detalle;
	}

	@Override
	public List<tmoGestionDto> tmoGestion(FiltroEntranteDTO filtro) {
		return repo.tmoGestion(filtro.getLoginAgente());
	}
	
		
	


	
}