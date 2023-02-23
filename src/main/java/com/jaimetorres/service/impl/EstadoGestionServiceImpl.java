package com.jaimetorres.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.EstadoGestion;
import com.jaimetorres.model.EstadoGestion;
import com.jaimetorres.repo.IEstadoGestionRepo;
import com.jaimetorres.repo.IGenericRepo;
import com.jaimetorres.service.IEstadoGestionService;

@Service
public class EstadoGestionServiceImpl extends CRUDImpl<EstadoGestion, Integer> implements IEstadoGestionService {

	@Autowired
	private IEstadoGestionRepo repo;
	
	@Override
	public EstadoGestion registrar(EstadoGestion cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public EstadoGestion modificar(EstadoGestion cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public List<EstadoGestion> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public EstadoGestion listarPorId(Integer id) throws Exception {
		//Opotional java 8 para capturar los null point exception
		Optional<EstadoGestion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new EstadoGestion();
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);
		
	}

	@Override
	public List<EstadoGestion> buscar(FiltroEntranteDTO filtro) {
		
		return repo.buscarEstadoP(filtro.getIdEmpresa(),  filtro.getIdTipoCampana());
		
	}

	@Override
	public List<EstadoGestion> buscarEstadoH(FiltroEntranteDTO filtro) {
		System.out.print("Hola mundo");
		return repo.buscarEstadoH(filtro.getIdEstadoPadre());
	}




		
}


