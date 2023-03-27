package com.jaimetorres.service;

import java.util.List;

import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.Contacto;


public interface IContactoService extends ICRUD<Contacto , Integer >{
	
	
	public Integer buscarMax(FiltroEntranteDTO filtro);
	Contacto buscar(Integer idContactoMax);
	
}
