package com.jaimetorres.service.gestor;


import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.FidelizacionComercial;


public interface IFidelizacionComercialService extends ICRUD < FidelizacionComercial , Integer >{
	
	List<FidelizacionComercial> buscarFidelizacionS(ParametrosDTO filtro);
}
