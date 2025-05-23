package com.jaimetorres.service.gestor.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.repo.gestor.IClienteRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;
import com.jaimetorres.service.gestor.IClienteService;

@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

	@Autowired
	private IClienteRepo repo;
	
	@Override
	protected IGenericRepo<Cliente, Integer> getRepo(){
		return repo;
	}
	
	@Override
	public List<Cliente> buscar(ParametrosDTO filtro) {
		return repo.buscar(filtro.getTipoDoc(),filtro.getNroDocumento());
		
	}
	
	@Override
	public Cliente buscarCliente(ParametrosDTO filtro) {
		return repo.buscarCliente(filtro.getTipoDoc(),filtro.getNroDocumento());
	}

	@Override
	public List<Cliente> buscarByCliente(ParametrosDTO filtro) {
		return repo.buscarByCliente(filtro.getIdCliente());
	}

	@Override
	public List<Cliente> buscarByClientes(ParametrosDTO filtro) {
		return repo.buscarByClientes(filtro.getIdCliente());
	}

	@Override
	public Cliente buscarIdAsterisk(Integer tipo, String nroDocumento) {
			return repo.buscarAsteriskCliente(tipo, nroDocumento);
	}

	@Override
	public Cliente buscarId(ParametrosDTO filtro) {
		return repo.buscarCargue(filtro.getTipoDoc(),filtro.getNroDocumento());
	}

			
}


