package com.jaimetorres.service.gestor.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.GestionComercialDto;
import com.jaimetorres.model.gestor.DetalleGestionComercial;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.IDetalleGestionComercialService;

@Service
public class DetalleGestionComercialServiceImpl extends CRUDImpl<DetalleGestionComercial, Integer> implements IDetalleGestionComercialService {

	@Autowired
	private IDetalleGestionComercialRepo repo;
	
	@Override
	protected IGenericRepo<DetalleGestionComercial, Integer> getRepo(){
		return repo;
	}

	@Override
	public List<GestionComercialDto> buscarGC(ParametrosDTO filtro) {
		
		List<GestionComercialDto> detalle = new ArrayList<>();
		repo.buscarGC(filtro.getFechaInicial(),filtro.getFechaFinal()).forEach(x -> {
			GestionComercialDto m = new GestionComercialDto();
			m.setFechaGestionCargue(String.valueOf(x[0]));  
			m.setTipoDocumento(String.valueOf(x[1]));     
			m.setNroDocumento(String.valueOf(x[2]));      
			m.setRazonSocial(String.valueOf(x[3]));        
			m.setContactoNombre(String.valueOf(x[4]));      
			m.setNumeroContacto(String.valueOf(x[5]));     
			m.setTelefonoCelular(String.valueOf(x[6]));    
			m.setCorreoElectronico(String.valueOf(x[7]));  
			m.setCiudad(String.valueOf(x[8]));             
			m.setDireccion(String.valueOf(x[9]));          
			m.setMotivoNombre(String.valueOf(x[10]));      
			m.setRegProyectados(String.valueOf(x[11]));    
			m.setEstadoNombre(String.valueOf(x[12]));      
			m.setObservacion(String.valueOf(x[13]));       
			m.setFechaGestion(String.valueOf(x[14]));       
			m.setUsuario(String.valueOf(x[15]));
			m.setIdDetalleComercial(x[16] != null ? (Integer) x[16] : null);
			
			// Luego, añades el objeto al listado
			detalle.add(m);
			
		});
		return detalle;
	}

//	@Override
//	public List<DetalleGestionComercial> buscarUsuarios(ParametrosDTO filtro) {
//		LocalDateTime fechaInicialloc =filtro.getFechaInicial();
//        LocalDateTime fechaFinalloc = filtro.getFechaFinal();
//
//        Date fechaInicial = Timestamp.valueOf(fechaInicialloc);  // Convertir a Date
//        Date fechaFinal = Timestamp.valueOf(fechaFinalloc);  
//		return repo.buscarUsuarios(fechaInicial, fechaFinal);
//	}

	


	
}