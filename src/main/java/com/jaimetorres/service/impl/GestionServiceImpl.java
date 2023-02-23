package com.jaimetorres.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.Gestion;
import com.jaimetorres.model.Gestion;
import com.jaimetorres.repo.IGestionRepo;
import com.jaimetorres.repo.IGenericRepo;
import com.jaimetorres.service.IGestionService;
import com.jaimetorres.service.IGestionService;

@Service
public class GestionServiceImpl extends CRUDImpl<Gestion, Integer> implements IGestionService {

	@Autowired
	private IGestionRepo repo;
	
	@Override
	public Gestion registrar(Gestion cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public Gestion modificar(Gestion cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public List<Gestion> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Gestion listarPorId(Integer id) throws Exception {
		//Opotional java 8 para capturar los null point exception
		Optional<Gestion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Gestion();
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);		
	}

	@Override
	public List<Gestion> buscar(FiltroEntranteDTO filtro) {
		System.out.print("Mundo");
		return null;
	}

	@Override
	public List<Gestion> buscarA(FiltroEntranteDTO filtro) {
		System.out.print("Hola");
		return repo.buscarA(filtro.getNroCliente());
	}

}


