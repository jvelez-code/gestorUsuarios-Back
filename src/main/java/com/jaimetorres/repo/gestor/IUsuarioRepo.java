package com.jaimetorres.repo.gestor;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.model.gestor.Usuario;
import com.jaimetorres.model.gestor.Usuarios;


public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer> {



	@Query("FROM Usuario u  WHERE u.usuario= :loginAgente")
	Usuario[] buscarUsuario(@Param("loginAgente") String loginAgente);	
	
	@Query("FROM Usuario u  WHERE u.usuario= :loginAgente")
	Usuario buscarLogin(@Param("loginAgente") String loginAgente);	
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM oauth_access_token oat where user_name = :loginAgente ", nativeQuery = true)
	void cerrarSesion(@Param("loginAgente") String loginAgente);
	
	@Query("FROM Usuarios u  WHERE u.username= :loginAgente")
	Usuarios buscarUsuarios(@Param("loginAgente") String loginAgente);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE usuarios SET intentos = intentos + 1 WHERE nombre = :loginAgente ", nativeQuery = true)
	void intentos(@Param("loginAgente") String loginAgente);
	
	
	@Query(value="SELECT u.* FROM usuario u, perfil p  WHERE u.id_perfil = p.id_perfil   AND empresa != '0' "
			+ "AND estado < '4' AND p.nombre = 'Agente PILA' ORDER BY usuario;", nativeQuery = true)
	List<Usuario> buscarCalidad();
	
	@Query(value="SELECT u.* FROM usuario u, perfil p  WHERE u.id_perfil = p.id_perfil   AND empresa= :idEmpresa "
			+ "AND estado < '4' AND p.nombre = 'Agente PILA' ORDER BY usuario;", nativeQuery = true)
	List<Usuario> buscarAsignar(@Param("idEmpresa") Integer idEmpresa);
	
	
	
}
