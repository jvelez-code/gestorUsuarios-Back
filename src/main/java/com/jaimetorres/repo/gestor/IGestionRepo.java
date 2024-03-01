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
	
	//Gestion Comercial
	@Transactional
	@Modifying	
	@Query(value="UPDATE detalle_gestion_comercial SET id_detalle_gestion = :idDetalleGestion WHERE id_gestion = :idGestion ", nativeQuery = true)
    void actualizarComercial(@Param("idGestion") Integer idGestion, @Param("idDetalleGestion") Integer idDetalleGestion);
	
	//Gestion Saliente
	@Query(value="SELECT id_gestion FROM gestion g WHERE id_campana= :campanaSal AND id_estado_gestion ='7' ORDER BY id_gestion LIMIT 1", nativeQuery = true)
    Integer buscarIdGestion(@Param("campanaSal") Integer campanaSal);
	
	@Transactional
	@Modifying	
	@Query(value="UPDATE  gestion SET id_estado_gestion ='4' WHERE id_gestion =:idGestion ", nativeQuery = true)
    void cambioEstado(@Param("idGestion") Integer idGestion);
	
	@Transactional
	@Modifying	
	@Query(value="UPDATE  gestion SET id_estado_gestion ='983', id_agente = :idUsuario, fecha_gestion =now(), usuario_act ='HELPVOZ13', "
			+ "ip_act ='127.0.1.1' WHERE id_gestion = :idGestion ", nativeQuery = true)
	void actualizarGestion(@Param("idGestion") Integer idGestion, @Param("idUsuario") Integer idUsuario);
	

	@Query(value="SELECT id_gestion AS idGestion, id_cliente AS idCliente FROM gestion WHERE id_gestion= :idGestion", nativeQuery = true)
	Map<String, Object> gestionSal (@Param("idGestion") Integer idGestion);

	
	
	



}