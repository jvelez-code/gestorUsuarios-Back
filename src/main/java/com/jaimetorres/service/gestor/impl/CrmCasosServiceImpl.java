package com.jaimetorres.service.gestor.impl;



import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroCrmCasosDTO;
import com.jaimetorres.dto.FiltroCrmDetallesDTO;
import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.CrmCasos;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.gestor.ICrmCasosService;

@Service
public class CrmCasosServiceImpl extends CRUDImpl<CrmCasos, Integer> implements ICrmCasosService {

	@Autowired
	private ICrmCasosRepo repo;
	
	@Override
	protected IGenericRepo<CrmCasos, Integer> getRepo(){
		return repo;
	}

	@Override
	public List<FiltroCrmCasosDTO> buscarCasosS(ParametrosDTO filtro) {
		
		List<FiltroCrmCasosDTO> detalle = new ArrayList<>();
		repo.buscarCasosR(filtro.getIdCliente()).forEach(x ->{
			FiltroCrmCasosDTO m = new FiltroCrmCasosDTO();
	        m.setIdCaso(Integer.valueOf(x[0].toString()));
	        m.setTipoDocumento(String.valueOf(x[1]));
	        m.setNroDocumento(String.valueOf(x[2]));
	        m.setNroRealmarcado(String.valueOf(x[3]));
	        m.setFechaCaso(String.valueOf(x[4]));
	        m.setFechaVencimiento(String.valueOf(x[5]));
	        m.setFechaCierre(String.valueOf(x[6]));
	        m.setNombreCategoria(String.valueOf(x[7]));
	        m.setNombreSubcategoria(String.valueOf(x[8]));
	        m.setNombreTipologia(String.valueOf(x[9]));
	        m.setNombreEstado(String.valueOf(x[10]));
	        m.setNombreNivel(String.valueOf(x[11]));
	        m.setNombreDepartamento(String.valueOf(x[12]));

	        detalle.add(m);
		});
		return detalle;
	}

	@Override
	public List<FiltroCrmCasosDTO> buscarEstadoR() {
		
		List<FiltroCrmCasosDTO> detalle = new ArrayList<>();
		repo.buscarEstadoR().forEach(x ->{
			FiltroCrmCasosDTO m = new FiltroCrmCasosDTO();
	        m.setIdCaso(Integer.valueOf(x[0].toString()));
	        m.setTipoDocumento(String.valueOf(x[1]));
	        m.setNroDocumento(String.valueOf(x[2]));
	        m.setNroRealmarcado(String.valueOf(x[3]));
	        m.setFechaCaso(String.valueOf(x[4]));
	        m.setFechaVencimiento(String.valueOf(x[5]));
	        m.setFechaCierre(String.valueOf(x[6]));
	        m.setNombreCategoria(String.valueOf(x[7]));
	        m.setNombreSubcategoria(String.valueOf(x[8]));
	        m.setNombreTipologia(String.valueOf(x[9]));
	        m.setNombreEstado(String.valueOf(x[10]));
	        m.setNombreNivel(String.valueOf(x[11]));
	        m.setNombreDepartamento(String.valueOf(x[12]));

	        detalle.add(m);
		});
		return detalle;
		
	}

	@Override
	public void actuEstadoR(FiltroCrmDetallesDTO filtro) {
		repo.actuEstado(filtro.getIdCrmEstado(), filtro.getFechaDetalle(), filtro.getIdCrmCaso());
	}

	@Override
	public CrmCasos registrarTransaccional(CrmCasos crmCasos) throws Exception {
		crmCasos.getListaDetalle().forEach(det -> det.setCrmCasos(crmCasos));
		return repo.save(crmCasos);
	}

	
}


