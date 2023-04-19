package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.EstadoGestion;


public interface IEstadoGestionService extends ICRUD<EstadoGestion , Integer >{
	
	List<EstadoGestion> buscar(FiltroEntranteDTO filtro);
	List<EstadoGestion> buscarEstadoH(FiltroEntranteDTO filtro);
	
}
