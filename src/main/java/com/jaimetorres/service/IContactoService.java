package com.jaimetorres.service;

import java.util.List;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.Contacto;


public interface IContactoService extends ICRUD<Contacto , Integer >{
	
	List<Contacto> buscar(FiltroEntranteDTO filtro);
}
