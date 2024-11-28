package com.jaimetorres.repo.gestor;


import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Gestion;


public interface IGestionRepo extends IGenericRepo<Gestion, Integer> {



	@Query("FROM Gestion g WHERE g.idGestion= :nroCliente ORDER BY g.idGestion DESC")
	Gestion buscarM (@Param("nroCliente") Integer nroCliente);

	@Query(value="SELECT * FROM gestion WHERE id_cliente= :nroCliente ", nativeQuery = true)
	List<Gestion> buscarA(@Param("nroCliente") Integer nroCliente);
	
	//GESTION COMERCIAL
	@Transactional
	@Modifying	
	@Query(value="UPDATE detalle_gestion_comercial SET id_detalle_gestion = :idDetalleGestion WHERE id_gestion = :idGestion ", nativeQuery = true)
    void actualizarComercial(@Param("idGestion") Integer idGestion, @Param("idDetalleGestion") Integer idDetalleGestion);
	
	//GESTION SALIENTE
	@Query(value="SELECT id_gestion FROM gestion g WHERE id_campana= :campanaSal AND id_estado_gestion ='7' LIMIT 1", nativeQuery = true)
    Integer buscarIdGestion(@Param("campanaSal") Integer campanaSal);
	
	@Transactional
	@Modifying	
	@Query(value="UPDATE  gestion SET id_estado_gestion ='4' WHERE id_gestion =:idGestion ", nativeQuery = true)
    void cambioEstado(@Param("idGestion") Integer idGestion);
	
	@Transactional
	@Modifying	
	@Query(value="UPDATE  gestion SET id_estado_gestion = :idEstadoGestion, id_agente = :idUsuario, fecha_gestion =now(), "
			+ "usuario_act = :usuarioact , ip_act = :ipAct WHERE id_gestion = :idGestion ", nativeQuery = true)
	void actualizarGestion(@Param("idEstadoGestion") Integer idEstadoGestion, @Param("idGestion") Integer idGestion, 
			@Param("idUsuario") Integer idUsuario, @Param("usuarioact") String usuarioact, @Param("ipAct") String ipAct);
	

	@Query(value="SELECT id_gestion AS idGestion, id_cliente AS idCliente FROM gestion WHERE id_gestion= :idGestion", nativeQuery = true)
	Map<String, Object> gestionSal (@Param("idGestion") Integer idGestion);

	
	//SECRETARIA VIRTUAL
	@Query(value="SELECT count(*) FROM gestion g, cliente c WHERE g.id_cliente =c.id_cliente "
			     + " AND g.fecha_gestion >=(NOW()-INTERVAL'8 HOUR') AND c.nro_documento = :numeroDocumento ", nativeQuery = true)
    Integer buscarGestion(@Param("numeroDocumento") String numeroDocumento);
	
	//CARGUE CAMPANA
	
	@Query(value = "SELECT COUNT(*) FROM gestion g WHERE g.id_campana = :campanaSal ", nativeQuery = true)
	Integer contarGestiones(@Param("campanaSal") Integer campanaSal);
	
	@Query(value = "SELECT COUNT(*) FROM gestion g WHERE g.id_campana = :campanaSal AND g.id_estado_gestion in ('7','4')", nativeQuery = true)
	Integer contarGestionesfalt(@Param("campanaSal") Integer campanaSal);


	
	
	
	
	



}