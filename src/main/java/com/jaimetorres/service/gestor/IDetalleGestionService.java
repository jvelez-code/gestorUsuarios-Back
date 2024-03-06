package com.jaimetorres.service.gestor;


import java.util.List;

import com.jaimetorres.dto.CantidadGestionDto;
import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.tmoGestionDto;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.EstadoGestion;
import com.jaimetorres.model.gestor.Gestion;


public interface IDetalleGestionService extends ICRUD<DetalleGestion , Integer >{
	
	List<Gestion> buscarHisto(ParametrosDTO filtro);
	List<FiltroDetalleGestionDTO> buscarM(ParametrosDTO filtro);
	List<CantidadGestionDto> cantidadGestion(ParametrosDTO filtro);
	//GESTION SALIENTE
	void guardarSaliente(DetalleGestion filtro);
	
}

