package com.jaimetorres.service;

import java.util.List;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.Gestion;


public interface IGestionService extends ICRUD<Gestion , Integer >{
	
	List<Gestion> buscar(FiltroEntranteDTO filtro);
	List<Gestion> buscarA(FiltroEntranteDTO filtro);
}
