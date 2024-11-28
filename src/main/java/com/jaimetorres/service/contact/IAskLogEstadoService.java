package com.jaimetorres.service.contact;

import com.jaimetorres.dto.FiltroEstadoDTO;
import com.jaimetorres.model.contact.AskLogEstado;

public interface IAskLogEstadoService extends ICRUDContact<AskLogEstado, Integer >  {
	
	Integer buscarExt (FiltroEstadoDTO filtro);
	void actualizarExt (Integer idLog);
	void registrarExt (FiltroEstadoDTO filtro);
	void registrarExtNue (FiltroEstadoDTO filtro);

}
