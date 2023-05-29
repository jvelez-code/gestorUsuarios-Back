package com.jaimetorres.repo.gestor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jaimetorres.model.gestor.Usuarios;



public interface ILoginRepo extends IGenericRepo<Usuarios, Integer>{

	@Query("FROM Usuarios us where us.username =:usuario")
	Usuarios verificarNombreUsuario(@Param("usuario")String usuario);
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuarios us SET us.password =:clave WHERE us.username =:nombre")
	void cambiarClave(@Param("clave") String clave, @Param("nombre") String nombre);
	
}
