package com.jaimetorres.service.gestor;


import java.util.List;

import com.jaimetorres.dto.DivipolaDto;
import com.jaimetorres.model.gestor.Divipola;

public interface IDivipolaService extends ICRUD<Divipola , Integer >{
	
	List<DivipolaDto> listaCiudades();

}
