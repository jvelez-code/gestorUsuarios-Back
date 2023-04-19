package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.Cliente;


public interface IClienteService extends ICRUD<Cliente , Integer >{
	
	Cliente buscar(FiltroEntranteDTO filtro);
	List<Cliente> buscarByCliente(FiltroEntranteDTO filtro);
	List<Cliente> buscarByClientes(FiltroEntranteDTO filtro);
	
}
