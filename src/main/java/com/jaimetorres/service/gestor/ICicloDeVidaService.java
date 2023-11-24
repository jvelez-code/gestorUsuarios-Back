package com.jaimetorres.service.gestor;


import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.CicloDeVida;


public interface ICicloDeVidaService extends ICRUD<CicloDeVida , Integer >{
	
 void actualizaCiclo(ParametrosDTO filtro);
}
