package com.jaimetorres.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.repo.gestor.IClienteRepo;
import com.jaimetorres.repo.gestor.IGenericRepo;
import com.jaimetorres.service.IClienteService;
import com.jaimetorres.service.contact.impl.CRUDContactImpl;

@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

	@Autowired
	private IClienteRepo repo;
	
	@Override
	protected IGenericRepo<Cliente, Integer> getRepo(){
		return repo;
	}
	
	@Override
	public Cliente buscar(FiltroEntranteDTO filtro) {
		return repo.buscar(filtro.getTipoDoc(),filtro.getNroDoc());
		
	}

	@Override
	public List<Cliente> buscarByCliente(FiltroEntranteDTO filtro) {
		System.out.println("hola Cliente");
		return repo.buscarByCliente(filtro.getIdCliente());
	}

	@Override
	public List<Cliente> buscarByClientes(FiltroEntranteDTO filtro) {
		return repo.buscarByClientes(filtro.getIdCliente());
	}




		
}


