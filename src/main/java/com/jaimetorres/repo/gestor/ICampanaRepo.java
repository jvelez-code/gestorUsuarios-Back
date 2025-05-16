package com.jaimetorres.repo.gestor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.Campana;


public interface ICampanaRepo extends IGenericRepo< Campana , Integer > {
	
	@Query(value="SELECT c.* FROM campana c, estado_campana ec "
			+ "WHERE c.id_estado_campana = ec.id_estado_campana   AND c.id_empresa = :idEmpresa   AND c.id_tipo_campana = :idTipoCampana "
			+ "AND ec.es_estado_final IS FALSE ORDER BY c.tiempo_cargue_campana DESC;", nativeQuery = true)
	List<Campana> buscarAsignacion(@Param("idEmpresa") Integer idEmpresa, @Param("idTipoCampana") Integer idTipoCampana);

	Optional<Campana> findByNombre(String campaignName);

}
