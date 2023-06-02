package com.jaimetorres.service.gestor;


import com.jaimetorres.dto.FiltroEntranteDTO;
import com.jaimetorres.model.gestor.Usuario;


public interface IUsuarioService extends ICRUD<Usuario , Integer >{
	
	Usuario buscar(FiltroEntranteDTO filtro);
	void cerrarSesion(FiltroEntranteDTO filtro);
}
