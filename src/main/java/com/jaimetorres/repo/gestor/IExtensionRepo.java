package com.jaimetorres.repo.gestor;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.jaimetorres.model.gestor.Extension;
import com.jaimetorres.model.gestor.Gestion;


public interface IExtensionRepo extends IGenericRepo< Extension , Integer > {
	
	@Query("FROM Extension e WHERE e.extension= :extension ")
	Extension findByid(@Param("extension") String extension);
	
	@Query("FROM Extension e WHERE e.empresa.idEmpresa= :idEmpresa ")
	List<Extension> buscarEmpresa2(@Param("idEmpresa") Integer idEmpresa);

	@Query(value="select * from extension e where e.empresa= :idEmpresa ORDER BY 1 ", nativeQuery = true)
	List<Extension> buscarEmpresa(@Param("idEmpresa") Integer idEmpresa);
	
	
		
	@Transactional
	@Modifying
    @Query("UPDATE Extension e SET e.usuario.idUsuario= NULL , e.disponible='si' WHERE e.extension= :extension")
    void actuaExtension(@Param("extension") String extension);

	@Transactional
	@Modifying
    @Query("UPDATE Extension e SET e.usuario.idUsuario= :idUsuario , e.disponible='no' WHERE e.extension= :extension AND  e.disponible='si' ")
    void asignarExtension(@Param("idUsuario") Integer idUsuario, @Param("extension") String extension);

	

}
