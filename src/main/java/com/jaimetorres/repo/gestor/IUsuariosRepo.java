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
	
	@Transactional
	@Modifying
	@Query(value="UPDATE usuarios SET ultimo_log = :ultimoLogin WHERE nombre = :loginAgente ", nativeQuery = true)
	void ultimoLoginR(@Param("loginAgente") String loginAgente, @Param("ultimoLogin") LocalDateTime ultimoLogin);
	
	@Query("FROM Usuarios u WHERE u.username= :username")
	Usuarios usuariosCalidad(@Param("username") String username);	
	

}
