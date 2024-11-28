package com.jaimetorres.service.gestor;


import java.io.IOException;
import java.util.List;

import com.jaimetorres.dto.AgenteDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.AgenteCampana;


public interface IAgenteCampanaService extends ICRUD<AgenteCampana , Integer >{
	
	AgenteDTO buscarCampana(ParametrosDTO filtro) throws IOException;
	
	void eliminarCampana(ParametrosDTO filtro);
	void guardarCampana(ParametrosDTO filtro);
	List<AgenteCampana> validarAsignacion(ParametrosDTO filtro);
	
}
