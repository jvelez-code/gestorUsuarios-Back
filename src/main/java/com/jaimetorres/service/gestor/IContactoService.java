package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Contacto;


public interface IContactoService extends ICRUD<Contacto , Integer >{
	
	
	public Integer buscarMax(ParametrosDTO filtro);
	Contacto buscar(Integer idContactoMax);
	
}
