package com.jaimetorres.service.gestor;

import com.jaimetorres.model.gestor.Usuarios;

public interface ILoginService {

	Usuarios verificarNombreUsuario(String usuario);
	void cambiarClave(String clave, String nombre);
	void cambiarIntento(String nombre);
}
