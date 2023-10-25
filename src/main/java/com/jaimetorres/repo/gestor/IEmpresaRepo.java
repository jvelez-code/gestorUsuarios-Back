package com.jaimetorres.repo.gestor;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.Empresa;


public interface IEmpresaRepo extends IGenericRepo< Empresa , Integer > {
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE usuario SET empresa= :idEmpresa WHERE usuario= :loginAgente ", nativeQuery = true)
	void modificar(@Param("idEmpresa") Integer idEmpresa, @Param("loginAgente") String loginAgente);

}
