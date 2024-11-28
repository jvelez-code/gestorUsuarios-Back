package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Campana;


public interface ICampanaService extends ICRUD<Campana , Integer >{
	
	List<Campana> asignarCampana (ParametrosDTO filtro);
	
}
