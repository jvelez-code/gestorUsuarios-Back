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
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.GestionComercialDto;
import com.jaimetorres.dto.tmoGestionDto;
import com.jaimetorres.model.gestor.DetalleGestionComercial;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.model.gestor.Menu;
import com.jaimetorres.model.gestor.Usuario;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
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
		System.out.println(filtro.getIdUsuario());
		System.out.println(filtro.getFechaFinal());
		System.out.println(filtro.getFechaInicial());
		repo.buscarGC(filtro.getFechaInicial(), filtro.getFechaFinal(), filtro.getIdUsuario()).forEach(x -> {
			GestionComercialDto m = new GestionComercialDto();
			m.setFechaGestionCargue(String.valueOf(x[0]));
			m.setTipoDocumentoCliente(String.valueOf(x[1]));
			m.setNroDocumentoCliente(String.valueOf(x[2]));
			m.setRazonSocialCliente(String.valueOf(x[3]));
			m.setNombreContacto(String.valueOf(x[4]));
			m.setNumeroContacto(String.valueOf(x[5]));
			m.setCelularContacto(String.valueOf(x[6]));
			m.setCorreoElectronicoContacto(String.valueOf(x[7]));
			m.setCiudadCliente(String.valueOf(x[8]));
			m.setDireccionCliente(String.valueOf(x[9]));
			m.setNombreMotivo(String.valueOf(x[10]));
			m.setRegProyectadosCliente(String.valueOf(x[11]));
			m.setNombreEstadoGestion(String.valueOf(x[12]));
			m.setRegObtenidosCliente(String.valueOf(x[13]));
			m.setObservacionDetGestion(String.valueOf(x[14]));
			m.setNroGestionRealizadaDetGestion(String.valueOf(x[15]));
			m.setCompromisosDetGestion(String.valueOf(x[16]));
			m.setFechaGestion(String.valueOf(x[17]));
			m.setIdDetalleGestionComercial((Integer) x[18]);
			m.setIdAgente((Integer) x[19]);
		    m.setIdCliente((Integer) x[20]);
			m.setGestionRealizada(String.valueOf(x[21]));
			m.setCiclodeVida(String.valueOf(x[22]));
			m.setActivar((boolean) x[23]);			
			detalle.add(m);
		});
		return detalle;
	}

	@Override
	public List<DetalleGestionComercial> buscarUsuarios(ParametrosDTO filtro) {
		return repo.buscarUsuarios(filtro.getFechaInicial(), filtro.getFechaFinal());
	}

	


	
}