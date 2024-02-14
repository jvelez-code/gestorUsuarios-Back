package com.jaimetorres.service.gestor.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.DivipolaDto;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
import com.jaimetorres.service.gestor.IGestionService;

@Service
public class GestionServiceImpl extends CRUDImpl<Gestion, Integer> implements IGestionService {

	@Autowired
	private IGestionRepo repo;
	
	@Override
	protected IGenericRepo<Gestion, Integer> getRepo(){
		return repo;
	}
	
	
	@Override
	public List<Gestion> buscar(ParametrosDTO filtro) {
		return null;
	}

	@Override
	public List<Gestion> buscarA(ParametrosDTO filtro) {
		return repo.buscarA(filtro.getIdCliente());
	}

	@Override
	public Gestion buscarM(ParametrosDTO filtro) {
		return repo.buscarM(filtro.getIdCliente());
	}


	@Override
	public Gestion registrarTransaccional(Gestion gestion) throws Exception {
		
		gestion.getListaDetalleGestion().forEach(det ->det.setGestion(gestion));
		gestion.getListaContacto().forEach(det ->det.setGestion(gestion));
		
		
		return repo.save(gestion);		
	}
	
	@Override
	public Gestion registrarTransaccionalComercial(Gestion gestion) throws Exception {
		
		gestion.getListaDetalleGestion().forEach(det ->det.setGestion(gestion));		
		gestion.getListaContacto().forEach(det ->det.setGestion(gestion));		
		gestion.getListaDetalleGestionComercial().forEach(det -> det.setGestion(gestion));
		
		return repo.save(gestion);		
	}


	@Override
	public void actualizarGestion(Integer id, Gestion gestion) {
			repo.actualizarGestion(gestion.getIdGestion(), gestion.getAgente().getIdUsuario());
			
        
	}


	@Override
	public Integer gestionSaliente(ParametrosDTO filtro) {
		return repo.buscarIdGestion(filtro.getCampanaSal());
	}


	@Override
	public void cambioEstadoGestion(Integer idgestion) {
		repo.cambioEstado(idgestion);		
	}


	@Override
	public ParametrosDTO buscarGestioSaliente(Integer idGestion) {		
			Map<String, Object> result = repo.gestionSal(idGestion);
		    ParametrosDTO parametrosDTO = new ParametrosDTO();
		    parametrosDTO.setIdGestion((Integer) result.get("idGestion"));
		    parametrosDTO.setIdCliente((Integer) result.get("idCliente"));
		    return parametrosDTO;
		}
	
	
	}




