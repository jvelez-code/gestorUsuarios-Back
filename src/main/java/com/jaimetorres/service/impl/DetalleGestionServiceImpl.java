package com.jaimetorres.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.DetalleGestion;
import com.jaimetorres.repo.IDetalleGestionRepo;
import com.jaimetorres.repo.IGenericRepo;
import com.jaimetorres.service.IDetalleGestionService;

@Service
public class DetalleGestionServiceImpl extends CRUDImpl<DetalleGestion, Integer> implements IDetalleGestionService {

	@Autowired
	private IDetalleGestionRepo repo;
	
	@Override
	public DetalleGestion registrar(DetalleGestion cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public DetalleGestion modificar(DetalleGestion cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public List<DetalleGestion> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public DetalleGestion listarPorId(Integer id) throws Exception {
		//Opotional java 8 para capturar los null point exception
		Optional<DetalleGestion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new DetalleGestion();
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);		
	}

	@Override
	public List<DetalleGestion> buscar(FiltroEntranteDTO filtro) {
		return repo.buscar(filtro.getNroCliente());
	}

//	@Override
//	public List<DetalleGestion> buscar(FiltroEntranteDTO filtro) {
//		return repo.buscar(filtro.getNroCliente() );
//	}		
}


