package com.jaimetorres.service.gestor.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.CantidadGestionDto;
import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.repo.gestor.*;
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
	public List<FiltroDetalleGestionDTO> buscarM(ParametrosDTO filtro) {
		
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
	public List<Gestion> buscarHisto(ParametrosDTO filtro) {
		// TODO Auto-generated method stub
		return repo.buscar(filtro.getIdCliente());
	}

	@Override
	public List<CantidadGestionDto> cantidadGestion(ParametrosDTO filtro) {
		List<CantidadGestionDto> detalle = new ArrayList<>();
		
		List<Object[]> result = repo.cantidadGestion(filtro.getIdUsuario());
		
		if (result != null && !result.isEmpty()) {
	        result.forEach(x -> {
	            CantidadGestionDto m = new CantidadGestionDto();
	            m.setEfectiva(String.valueOf(x[0]));
	            m.setCantidad(String.valueOf(x[1]));
	            detalle.add(m);
	        });
	    } else {
	        
	         CantidadGestionDto m = new CantidadGestionDto();
	         m.setEfectiva("0");
	         m.setCantidad("0");
	         detalle.add(m);
	         return detalle;
	    }

	    return detalle;
	}

	@Override
	public void guardarSaliente(DetalleGestion filtro, Integer idGestion) {
		
		repo.guardarSaliente(idGestion,filtro.getUsuario().getIdUsuario(), 
				filtro.getEstadoGestion().getIdEstadoGestion(),filtro.getExtension().getExtension(), 
				filtro.getObservacion(), filtro.getUsuarioAct(), filtro.getNumRealMarcado());
		
	}

	
}
