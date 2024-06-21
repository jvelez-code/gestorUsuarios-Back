package com.jaimetorres.repo.gestor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jaimetorres.model.gestor.Usuarios;



public interface ILoginRepo extends IGenericRepo<Usuarios, Integer>{

	@Query("FROM Usuarios us where us.email =:email")
	Usuarios verificarNombreUsuario(@Param("email")String email);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE usuarios SET clave = :clave, intentos= 0, fechaactualizacion = NOW(), fecha_cambio = CURRENT_TIMESTAMP + INTERVAL '1 MONTH' WHERE nombre = :nombre", nativeQuery = true)
	void cambiarClave(@Param("clave") String clave, @Param("nombre") String nombre);
	
}
