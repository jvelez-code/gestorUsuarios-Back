package com.jaimetorres.service.contact;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.FiltroEstadoDTO;
import com.jaimetorres.dto.LlamadaEntranteDTO;
import com.jaimetorres.model.contact.AskEstadoExtension;
import com.jaimetorres.model.contact.LlamadaEntrante;

public interface ILlamadaEntranteService extends ICRUDContact<LlamadaEntrante, Integer >  {
	
	LlamadaEntrante buscarIdAsterisk (ParametrosDTO filtro);
	List<LlamadaEntranteDTO> entranteSinRegistro (ParametrosDTO filtro);
	String validarAsterisk (ParametrosDTO filtro);

}
