package com.jaimetorres.service.gestor;


import java.util.List;

import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.Gestion;


public interface IDetalleGestionService extends ICRUD<DetalleGestion , Integer >{
	
	List<Gestion> buscarHisto(FiltroEntranteDTO filtro);
	List<FiltroDetalleGestionDTO> buscarM(FiltroEntranteDTO filtro);
}
