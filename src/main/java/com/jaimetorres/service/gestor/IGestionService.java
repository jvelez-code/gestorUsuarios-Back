package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.Gestion;


public interface IGestionService extends ICRUD<Gestion , Integer >{
	
	Gestion registrarTransaccional(Gestion gestion) throws Exception;
	
	List<Gestion> buscar(FiltroEntranteDTO filtro);
	
	List<Gestion> buscarA(FiltroEntranteDTO filtro);
	
	Gestion buscarM(FiltroEntranteDTO filtro);
}
