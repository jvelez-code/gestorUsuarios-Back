package com.jaimetorres.service.contact;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.FiltroEstadoDTO;
import com.jaimetorres.model.contact.AskEstadoExtension;

public interface IAskEstadoExtensionService extends ICRUDContact<AskEstadoExtension, Integer >  {
	
	AskEstadoExtension buscar (ParametrosDTO filtro);
	AskEstadoExtension buscarAgente (ParametrosDTO filtro);
	void cambioEstado (FiltroEstadoDTO filtro);

}
