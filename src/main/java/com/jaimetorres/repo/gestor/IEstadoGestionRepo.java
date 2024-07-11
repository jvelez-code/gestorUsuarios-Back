
package com.jaimetorres.repo.gestor;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.dto.estadoComercialDto;
import com.jaimetorres.model.gestor.EstadoGestion;



public interface IEstadoGestionRepo extends IGenericRepo<EstadoGestion, Integer> {
	
	
	
	@Query("FROM EstadoGestion e WHERE e.empresa.idEmpresa= :idEmpresa AND e.idEstadoGestionPadre is null "
			+ "AND e.aplicaDG is TRUE AND e.tipoLlamada= :tipoLlamada ORDER BY e.nombre")
	List<EstadoGestion> buscarEstadoP(@Param("idEmpresa") Integer idEmpresa, @Param("tipoLlamada") Integer tipoLlamada );
	
	@Query("FROM EstadoGestion e WHERE e.idEstadoGestionPadre= :idEstadoPadre ORDER BY e.nombre")
	List<EstadoGestion> buscarEstadoH(@Param("idEstadoPadre") Integer idEstadoPadre );
	
	@Query("SELECT e.nombre FROM EstadoGestion e WHERE e.idEstadoGestionPadre is NULL AND e.empresa.idEmpresa= :idEmpresa "
			+ "AND e.nombre NOT IN ('FIDELIZAR','RECUPERAR','CAPACITAR','VINCULAR') AND e.tipoLlamada='0' ")
	List<estadoComercialDto> estadoComercial2(@Param("idEmpresa") Integer idEmpresa);

	
	@Query(value="select id_estado_gestion as idEstadoGestion , nombre from estado_gestion eg "
			+ "where id_estado_gestion_padre is null and  id_empresa ='12' "
			+ "and nombre not in ('FIDELIZAR','RECUPERAR','CAPACITAR','VINCULAR') "
			+ "and tipo_llamada ='0' "
			+ "order by nombre", nativeQuery = true )
	List<Object[]> estadoComercial(@Param("idEmpresa") Integer idEmpresa);
	
	
	//Secretaria Virtual
	@Query("FROM EstadoGestion e WHERE e.tipoLlamada= 2 AND e.empresa.idEmpresa= :idEmpresa AND e.idEstadoGestionPadre is null "
			+ "AND e.aplicaDG is TRUE ORDER BY e.nombre")
	List<EstadoGestion> buscarSecretaria(@Param("idEmpresa") Integer idEmpresa);
	
	
	
	

}
