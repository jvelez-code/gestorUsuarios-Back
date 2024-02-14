package com.jaimetorres.service.contact.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.TmoGestionUsuarioDto;
import com.jaimetorres.dto.FiltroEstadoDTO;
import com.jaimetorres.dto.LlamadaEntranteDTO;
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
	public LlamadaEntrante buscarIdAsterisk(ParametrosDTO filtro) {
		return repo.buscarIdAsterisk(filtro.getNroDocumento());
	}
	
	@Override
	public List<LlamadaEntranteDTO> entranteSinRegistro(ParametrosDTO filtro) {
		
		List<LlamadaEntranteDTO> detalle = new ArrayList<>();
		
		repo.buscarIdEntrante(filtro.getNroDocumento()).forEach(x -> {
			LlamadaEntranteDTO m = new LlamadaEntranteDTO(null, null, null, null);
			m.setId_asterisk(String.valueOf(x[0]));
			m.setNumero_documento(String.valueOf(x[1]));
			m.setTipo_doc(String.valueOf(x[2]));			
			detalle.add(m);
		});
		return detalle;
		
	}

	@Override
	public String validarAsterisk(ParametrosDTO filtro) {
				
		String resultado = repo.validarAsterisk(filtro.getNroDocumento(), filtro.getTipoDoc());
	    
	    if (resultado == null) {
	        // No se encontraron datos
	        System.out.println("No se encontraron datos para validar.");
	    } else {
	        // Se encontraron datos
	        System.out.println("Datos encontrados: " + resultado);
	    }
	    
	    return resultado;
	}
	
	
	@Override
	public TmoGestionUsuarioDto validarTmo(ParametrosDTO filtro) {
		
		Object[] result = repo.validarTMO(filtro.getNroDocumento());
		TmoGestionUsuarioDto dto = new TmoGestionUsuarioDto((String) result[0]);
		return dto;

		
	}

	

	

	
	
	

}
