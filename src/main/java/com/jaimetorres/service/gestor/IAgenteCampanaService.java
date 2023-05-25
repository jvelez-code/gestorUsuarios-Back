package com.jaimetorres.service.gestor;


import java.util.List;

import com.jaimetorres.dto.AgenteDTO;
import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.AgenteCampana;


public interface IAgenteCampanaService extends ICRUD<AgenteCampana , Integer >{
	
	AgenteDTO buscarCampana(FiltroEntranteDTO filtro);
}
