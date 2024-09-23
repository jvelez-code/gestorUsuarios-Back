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
	public LlamadaEntranteDTO entranteSinRegistro(ParametrosDTO filtro) {
		
		List<Object[]> results = repo.buscarIdEntrante(filtro.getNroDocumento());
		  
		if (results.isEmpty()) {
	            return null;
	        }
		
		Object[] row = results.get(0); // Suponiendo que solo hay un resultado
        return new LlamadaEntranteDTO(
            (String) row[0],
            (String) row[1],
            (String) row[2],
            (String) row[3],
            (String) row[4], null, null
        );
    
		
	}

	@Override
	public String validarAsterisk(ParametrosDTO filtro) {
				
		String resultado = repo.validarAsterisk(filtro.getNroDocumento());
	    if (resultado == null) {
	        resultado="AGENTLOGOFF";
	        System.out.println("No se encontraron datos para validar.");
	    } 
	    
	    return resultado;
	}
	
	
	@Override
	public TmoGestionUsuarioDto validarTmo(ParametrosDTO filtro) {
		
		Object[] result = repo.validarTMO(filtro.getNroDocumento());
		TmoGestionUsuarioDto dto = new TmoGestionUsuarioDto((String) result[0]);
		return dto;		
	}

	@Override
	public synchronized LlamadaEntrante buscarSecreVirt(LlamadaEntranteDTO filtro) {		
		return repo.secretariaVirtual(filtro.getEmpresa());
	}

	@Override
	public synchronized void actualSecreVirt(LlamadaEntranteDTO filtro) {
		repo.cambioEstadoSecVirt(filtro.getIdAgente(),filtro.getIdLlamadaEntrante());
	}

	@Override
	public void limpiarSecre(LlamadaEntranteDTO filtro) {
		repo.limpiarSecretaria(filtro.getnumeroDocumento(), filtro.getIdLlamadaEntrante());
	}

	@Override
	public void devoluSecreVirt(LlamadaEntranteDTO filtro) {
		repo.devolverEstadoSecVirt(filtro.getIdLlamadaEntrante());		
	}


	

	

	
	
	

}
