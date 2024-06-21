package com.jaimetorres.repo.gestor;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.jaimetorres.model.gestor.CrmCasos;


public interface ICrmCasosRepo extends IGenericRepo < CrmCasos, Integer> {
	
	@Query("FROM CrmCasos c JOIN c.cliente u WHERE u.idCliente= :idCliente ")
	List<CrmCasos> buscarCasosR(@Param("idCliente") Integer idCliente );
	
	@Query("FROM CrmCasos c JOIN c.crmEstado e WHERE e.nombreEstado = 'Abierto' ORDER BY c.fechaGestion DESC ")
	List<CrmCasos> buscarEstadoR();
	
	@Transactional
	@Modifying	
	@Query(value="UPDATE crm_casos SET id_estado = :id_estado WHERE id_caso = :id_caso' ", nativeQuery = true)
    void actuEstado(@Param("id_estado") Integer id_estado, @Param("id_caso") Integer id_caso );
	

	
	
	

}
