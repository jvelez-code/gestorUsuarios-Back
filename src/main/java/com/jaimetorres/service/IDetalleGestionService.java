package com.jaimetorres.service;

import java.util.List;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.DetalleGestion;


public interface IDetalleGestionService extends ICRUD<DetalleGestion , Integer >{
	
	List<DetalleGestion> buscar(FiltroEntranteDTO filtro);
}
