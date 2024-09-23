package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Cliente;


public interface IClienteService extends ICRUD<Cliente , Integer >{
	
	List<Cliente> buscar(ParametrosDTO filtro);
	List<Cliente> buscarByCliente(ParametrosDTO filtro);
	List<Cliente> buscarByClientes(ParametrosDTO filtro);
	Cliente buscarIdAsterisk(Integer tipo, String nroDocumento);
	//CARGUE CAMPANA		
	Cliente buscarId(ParametrosDTO filtro);
	
}
