package com.jaimetorres.service.gestor;


import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Usuario;
import com.jaimetorres.model.gestor.Usuarios;


public interface IUsuarioService extends ICRUD<Usuario , Integer >{
	
	Usuario[] buscar(ParametrosDTO filtro);
	void cerrarSesion(ParametrosDTO filtro);
	Usuarios buscarLogin(ParametrosDTO filtro);
	
	//INTENTOS FALLIDOS
	void intentoFallido(ParametrosDTO filtro);
	
	//CALIDAD
	List<Usuario> buscarCalidad();
	
	//ASIGNAR CAMPAÑA
	List<Usuario> buscarAsignaciones(ParametrosDTO filtro);

	//ASIGNAR  EXTENSIÓN
	List<Usuario> listarEmpresa(ParametrosDTO filtro);
	void actualizarAct(ParametrosDTO filtro);
}
