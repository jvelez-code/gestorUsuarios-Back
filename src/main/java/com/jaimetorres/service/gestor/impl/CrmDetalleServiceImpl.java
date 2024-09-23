package com.jaimetorres.service.gestor.impl;



import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroCrmCasosDTO;
import com.jaimetorres.dto.FiltroCrmDetallesDTO;
import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.CrmDetalle;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmDetalleService;

@Service
public class CrmDetalleServiceImpl extends CRUDImpl<CrmDetalle, Integer> implements ICrmDetalleService {

	@Autowired
	private ICrmDetalleRepo repo;
	
	@Override
	protected IGenericRepo<CrmDetalle, Integer> getRepo(){
		return repo;
	}

	@Override
	public List<FiltroCrmDetallesDTO> buscarDetalleS(Integer id) {
		List<FiltroCrmDetallesDTO> detalle = new ArrayList<>();
		repo.buscarDetalleR(id).forEach(x ->{
			FiltroCrmDetallesDTO m = new FiltroCrmDetallesDTO();
			m.setIdDetalle(Integer.valueOf(x[0].toString()));
			m.setFechaDetalle(String.valueOf(x[1]));
			m.setObservacion(String.valueOf(x[2]));
			m.setUsuario(String.valueOf(x[3]));
			detalle.add(m);
		});
		return detalle;
	}

	@Override
	public void registrarObser(FiltroCrmDetallesDTO filtroCrmDetallesDTO) {
		
		repo.registrar(filtroCrmDetallesDTO.getFechaDetalle(),filtroCrmDetallesDTO.getObservacion(), filtroCrmDetallesDTO.getIdCrmCaso(), filtroCrmDetallesDTO.getIdUsuario());
	}
	
}


