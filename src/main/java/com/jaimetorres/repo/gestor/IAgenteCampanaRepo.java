package com.jaimetorres.repo.gestor;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.AgenteCampana;


public interface IAgenteCampanaRepo extends IGenericRepo<AgenteCampana, Integer> {



	@Query("FROM AgenteCampana a "
			+ "JOIN FETCH a.usuario u JOIN FETCH a.campana ca JOIN FETCH ca.tipoCampana tp "
			+ "WHERE u.usuario= :loginAgente AND a.activo = true AND tp.tipoLlamada = 'Entrante' " )
	AgenteCampana buscarAgenteCampanaE(@Param("loginAgente") String loginAgente);
	
	@Query("FROM AgenteCampana a "
			+ "JOIN FETCH a.usuario u JOIN FETCH a.campana ca JOIN FETCH ca.tipoCampana tp "
			+ "WHERE u.usuario= :loginAgente AND a.activo = true AND tp.tipoLlamada = 'Saliente' " )
	AgenteCampana buscarAgenteCampanaS(@Param("loginAgente") String loginAgente);
	
	
	//ASIGNAR CAMPAÑA
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM agente_campana WHERE id_agente_campana IN ( "
	        + "SELECT id_agente_campana FROM agente_campana ac "
	        + "JOIN campana c ON ac.id_campana = c.id_campana "
	        + "JOIN tipo_campana tc ON c.id_tipo_campana = tc.id_tipo_campana "
	        + "WHERE ac.id_agente IN (:idAgentes) AND tc.id_tipo_campana = :tipoCampana)", 
	       nativeQuery = true)
	void eliminarCampana(@Param("idAgentes") List<Integer> idAgentes, @Param("tipoCampana") Integer tipoCampana);
	
	@Query("FROM AgenteCampana c WHERE c.campana.idCampana = :campanaSal " )
	List<AgenteCampana> validarAsignacion(@Param("campanaSal") Integer campanaSal);
	


	

}
