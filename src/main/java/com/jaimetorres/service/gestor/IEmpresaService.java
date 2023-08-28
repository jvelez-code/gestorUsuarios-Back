package com.jaimetorres.service.gestor;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.Empresa;


public interface IEmpresaService extends ICRUD<Empresa , Integer >{
	
	public void modificar(FiltroEntranteDTO filtro);
	
}
