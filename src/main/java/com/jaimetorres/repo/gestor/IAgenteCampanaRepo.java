package com.jaimetorres.repo.gestor;


import java.util.List;

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
	

}
