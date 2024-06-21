package com.jaimetorres.service.gestor;


import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Usuario;
import com.jaimetorres.model.gestor.Usuarios;


public interface IUsuarioService extends ICRUD<Usuario , Integer >{
	
	Usuario[] buscar(ParametrosDTO filtro);
	void cerrarSesion(ParametrosDTO filtro);
	Usuarios buscarLogin(ParametrosDTO filtro);
	
	//INTENTOS FALLIDOS
	void intentoFallido(ParametrosDTO filtro);
}
