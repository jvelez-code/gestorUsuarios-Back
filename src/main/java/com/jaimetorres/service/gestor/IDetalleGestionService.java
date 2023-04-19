package com.jaimetorres.service.gestor;


import java.util.List;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.DetalleGestion;


public interface IDetalleGestionService extends ICRUD<DetalleGestion , Integer >{
	
	List<DetalleGestion> buscarHisto(FiltroEntranteDTO filtro);
}
