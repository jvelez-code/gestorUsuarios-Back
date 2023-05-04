package com.jaimetorres.service.contact;


import java.util.List;

import com.jaimetorres.model.contact.AskEstado;


public interface IAskEstadoService extends ICRUDContact<AskEstado, Integer >  {
	
	List<AskEstado> buscar ();
}
