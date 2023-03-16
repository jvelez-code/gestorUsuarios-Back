package com.jaimetorres.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.DetalleGestion;


public interface IDetalleGestionService extends ICRUD<DetalleGestion , Integer >{
	
	List<DetalleGestion> buscarHisto(FiltroEntranteDTO filtro);
}
