package com.jaimetorres.service.contact;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.dto.FiltroEstadoDTO;
import com.jaimetorres.model.contact.AskEstadoExtension;

public interface IAskEstadoExtensionService extends ICRUDContact<AskEstadoExtension, Integer >  {
	
	AskEstadoExtension buscar (FiltroEntranteDTO filtro);
	AskEstadoExtension buscarAgente (FiltroEntranteDTO filtro);
	void cambioEstado (FiltroEstadoDTO filtro);

}
