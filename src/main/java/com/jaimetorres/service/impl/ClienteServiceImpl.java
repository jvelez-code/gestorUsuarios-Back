package com.jaimetorres.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.Cliente;
import com.jaimetorres.repo.IClienteRepo;
import com.jaimetorres.repo.IGenericRepo;
import com.jaimetorres.service.IClienteService;

@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

	@Autowired
	private IClienteRepo repo;
	
	@Override
	public Cliente registrar(Cliente cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public Cliente modificar(Cliente cli) throws Exception {
		return repo.save(cli);
	}

	@Override
	public List<Cliente> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Cliente listarPorId(Integer id) throws Exception {
		//Opotional java 8 para capturar los null point exception
		Optional<Cliente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Cliente();
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);
		
	}

	@Override
	public List<Cliente> buscar(FiltroEntranteDTO filtro) {
		
		return repo.buscar(filtro.getTipoDoc(),filtro.getNroDoc());
	}

	@Override
	public List<Cliente> buscarByCliente(FiltroEntranteDTO filtro) {
		return repo.buscarByCliente(filtro.getNroCliente());
	}



		
}


