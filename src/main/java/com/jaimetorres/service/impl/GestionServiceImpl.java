package com.jaimetorres.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.repo.gestor.*;
import com.jaimetorres.service.IGestionService;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;

@Service
public class GestionServiceImpl extends CRUDImpl<Gestion, Integer> implements IGestionService {

	@Autowired
	private IGestionRepo repo;
	
	@Override
	protected IGenericRepo<Gestion, Integer> getRepo(){
		return repo;
	}
	
	
	@Override
	public List<Gestion> buscar(FiltroEntranteDTO filtro) {
		System.out.print("Mundo");
		return null;
	}

	@Override
	public List<Gestion> buscarA(FiltroEntranteDTO filtro) {
		System.out.print("Hola");
		return repo.buscarA(filtro.getIdCliente());
	}

	@Override
	public Gestion buscarM(FiltroEntranteDTO filtro) {
		return repo.buscarM(filtro.getIdCliente());
	}


	@Override
	public Gestion registrarTransaccional(Gestion gestion) throws Exception {
		
		gestion.getListaDetalleGestion().forEach(det ->det.setGestion(gestion));
		
		gestion.getListaContacto().forEach(det ->det.setGestion(gestion));
		
		return repo.save(gestion);		
	}




}


