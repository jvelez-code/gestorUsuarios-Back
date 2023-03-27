package com.jaimetorres.repo.gestor;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.EstadoGestion;



public interface IEstadoGestionRepo extends IGenericRepo<EstadoGestion, Integer> {
	
	
	
	@Query("FROM EstadoGestion e WHERE e.empresa.idEmpresa= :idEmpresa AND e.idEstadoGestionPadre is null "
			+ "AND e.aplicaDG is TRUE AND e.tipoLlamada= :tipoLlamada ORDER BY e.nombre")
	List<EstadoGestion> buscarEstadoP(@Param("idEmpresa") Integer idEmpresa, @Param("tipoLlamada") Integer tipoLlamada );
	
	@Query("FROM EstadoGestion e WHERE e.idEstadoGestionPadre= :idEstadoPadre ORDER BY e.nombre")
	List<EstadoGestion> buscarEstadoH(@Param("idEstadoPadre") Integer idEstadoPadre );
	
	

}
