package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.FiltroCrmDetallesDTO;
import com.jaimetorres.model.gestor.CrmDetalle;


public interface ICrmDetalleService extends ICRUD < CrmDetalle , Integer >{
	
	List<FiltroCrmDetallesDTO> buscarDetalleS(Integer id);
	void registrarObser(FiltroCrmDetallesDTO filtroCrmDetallesDTO);
	

}
