package com.jaimetorres.service;

import java.util.List;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.Contacto;


public interface IContactoService extends ICRUD<Contacto , Integer >{
	
	
	public Integer buscarMax(FiltroEntranteDTO filtro);
	List<Contacto> buscar(Integer idContactoMax);
	
}
