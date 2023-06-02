package com.jaimetorres.repo.gestor;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jaimetorres.model.gestor.Usuario;


public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer> {



	@Query("FROM Usuario u  WHERE u.usuario= :loginAgente")
	Usuario buscarUsuario(@Param("loginAgente") String loginAgente);
	
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM oauth_access_token oat where user_name = :loginAgente ", nativeQuery = true)
	void cerrarSesion(@Param("loginAgente") String loginAgente);
	
	
}
