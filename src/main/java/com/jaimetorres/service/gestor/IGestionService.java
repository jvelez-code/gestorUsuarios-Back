package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Gestion;


public interface IGestionService extends ICRUD<Gestion , Integer >{
	
	Gestion registrarTransaccional(Gestion gestion) throws Exception;
	
	List<Gestion> buscar(ParametrosDTO filtro);
	
	List<Gestion> buscarA(ParametrosDTO filtro);
	
	Gestion buscarM(ParametrosDTO filtro);
}
