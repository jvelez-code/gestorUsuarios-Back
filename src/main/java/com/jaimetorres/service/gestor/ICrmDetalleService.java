package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.CrmDetalle;


public interface ICrmDetalleService extends ICRUD < CrmDetalle , Integer >{
	
	List<CrmDetalle> buscarDetalleS(Integer id);
	

}
