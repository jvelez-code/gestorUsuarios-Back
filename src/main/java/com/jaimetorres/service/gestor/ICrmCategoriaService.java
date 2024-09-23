package com.jaimetorres.service.gestor;

import com.jaimetorres.dto.FiltroCrmDetallesDTO;
import com.jaimetorres.model.gestor.CrmCategoria;


public interface ICrmCategoriaService extends ICRUD < CrmCategoria , Integer >{
	
	CrmCategoria diasVencimiento (FiltroCrmDetallesDTO filtro);
	

}
