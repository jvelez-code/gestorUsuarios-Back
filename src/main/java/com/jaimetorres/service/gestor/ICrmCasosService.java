package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.CrmCasos;

public interface ICrmCasosService extends ICRUD < CrmCasos , Integer > {
	
	List<CrmCasos> buscarCasosS(ParametrosDTO filtro);
	List<CrmCasos> buscarEstadoR();
	void actuEstadoR(ParametrosDTO filtro);
	

}
