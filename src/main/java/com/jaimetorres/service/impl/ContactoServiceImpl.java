package com.jaimetorres.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.Contacto;
import com.jaimetorres.repo.IContactoRepo;
import com.jaimetorres.repo.IGenericRepo;
import com.jaimetorres.service.IContactoService;

@Service
public class ContactoServiceImpl extends CRUDImpl<Contacto, Integer> implements IContactoService {

	@Autowired
	private IContactoRepo repo;
	
	@Override
	public Contacto registrar(Contacto cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public Contacto modificar(Contacto cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public List<Contacto> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Contacto listarPorId(Integer id) throws Exception {
		//Opotional java 8 para capturar los null point exception
		Optional<Contacto> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Contacto();
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);
		
	}

	@Override
	public List<Contacto> buscar(FiltroEntranteDTO filtro) {
		return repo.buscar(filtro.getNroCliente());
	}

	



		
}


