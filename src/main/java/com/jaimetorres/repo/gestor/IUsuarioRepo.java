package com.jaimetorres.repo.gestor;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
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
	
	@Query(value="SELECT u.* FROM usuario u,usuarios u2, usuario_rol ur, rol r " +
				"WHERE u.usuario = u2.nombre  and u2.idusuario=ur.id_usuario and ur.id_rol =r.idrol and r.descripcion like ('Agente%') " + 
				"and u.empresa= :idEmpresa " + 
				"AND u.estado < '4' ORDER BY usuario ", nativeQuery = true)
	List<Usuario> buscarAsignar(@Param("idEmpresa") Integer idEmpresa);
	
    @Query(value = "SELECT u.* FROM usuario u, usuarios us WHERE u.usuario = us.nombre  \n" + //
				"AND u.id_usuario NOT IN (SELECT e.id_usuario \n" + //
				"FROM extension e WHERE e.id_usuario IS NOT NULL) AND u.empresa= :idEmpresa AND us.estado = TRUE",nativeQuery = true) 
	List<Usuario> usuariosEmpresa(@Param("idEmpresa") Integer idEmpresa); 
    
	@Modifying
	@Transactional
	@Query("UPDATE Usuario u  SET u.estado = :estado WHERE u.usuario= :loginAgente")
	void usuarioActivo(@Param("loginAgente") String loginAgente, @Param("estado") Integer estado);	
}
