package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.FiltroCrmCasosDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.CrmCasos;

public interface ICrmCasosService extends ICRUD < CrmCasos , Integer > {
	
	List<FiltroCrmCasosDTO> buscarCasosS(ParametrosDTO filtro);
	List<FiltroCrmCasosDTO> buscarEstadoR();
	void actuEstadoR(ParametrosDTO filtro);
	CrmCasos registrarTransaccional(CrmCasos crmCasos) throws Exception;
	

}
