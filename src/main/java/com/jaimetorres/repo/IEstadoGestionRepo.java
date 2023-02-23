package com.jaimetorres.repo;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.jaimetorres.model.EstadoGestion;



public interface IEstadoGestionRepo extends IGenericRepo<EstadoGestion, Integer> {
	
	
	
	@Query("FROM EstadoGestion e WHERE e.idEstadoGestionPadre is null "
			+ "AND e.empresa.idEmpresa= :idEmpresa AND e.tipoCampana.idTipoCampana= :idTipoCampana ORDER BY e.nombre")
	List<EstadoGestion> buscarEstadoP(@Param("idEmpresa") Integer idEmpresa, @Param("idTipoCampana") Integer idTipoCampana );
	
	@Query("FROM EstadoGestion e WHERE e.idEstadoGestionPadre= :idEstadoPadre ORDER BY e.nombre")
	List<EstadoGestion> buscarEstadoH(@Param("idEstadoPadre") Integer idEstadoPadre );
	
	

}
