package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.UsuariosClaves;


public interface IUsuariosClavesService extends ICRUD<UsuariosClaves , Integer > {
	
	boolean buscarClaves(ParametrosDTO filtro);
	
	
}
