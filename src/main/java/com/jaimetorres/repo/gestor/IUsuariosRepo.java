package com.jaimetorres.repo.gestor;





import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.jaimetorres.model.gestor.Usuarios;

public interface IUsuariosRepo extends IGenericRepo<Usuarios, Integer> {
	
	Usuarios findOneByUsername(String username);
	Usuarios findOneByEmail(String email);	
	
	@Transactional
	@Modifying
	@Query(value="UPDATE usuarios SET ultimo_log = :ultimoLogin WHERE nombre = :loginAgente ", nativeQuery = true)
	void ultimoLoginR(@Param("loginAgente") String loginAgente, @Param("ultimoLogin") LocalDateTime ultimoLogin);
	
	@Query("FROM Usuarios u WHERE u.username= :username")
	Usuarios usuariosCalidad(@Param("username") String username);	
	
	@Query(value = "SELECT us.* FROM usuario u, usuarios us, usuario_rol ur WHERE u.usuario = us.nombre AND us.idusuario = ur.id_usuario AND u.id_usuario NOT IN (SELECT e.id_usuario FROM extension e WHERE e.id_usuario IS NOT NULL) AND u.empresa = :idEmpresa AND us.estado = TRUE AND ur.id_rol = 4",nativeQuery = true) 
	List<Usuarios> usuariosEmpresa(@Param("idEmpresa") Integer idEmpresa); 


}
