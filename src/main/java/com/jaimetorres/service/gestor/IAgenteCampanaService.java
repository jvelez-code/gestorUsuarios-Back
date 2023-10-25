package com.jaimetorres.service.gestor;


import com.jaimetorres.dto.AgenteDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.AgenteCampana;


public interface IAgenteCampanaService extends ICRUD<AgenteCampana , Integer >{
	
	AgenteDTO buscarCampana(ParametrosDTO filtro);
}
