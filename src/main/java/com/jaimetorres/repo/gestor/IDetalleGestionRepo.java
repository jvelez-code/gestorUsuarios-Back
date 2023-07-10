package com.jaimetorres.repo.gestor;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.dto.CantidadGestionDto;
import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.model.gestor.Menu;


public interface IDetalleGestionRepo extends IGenericRepo<DetalleGestion, Integer> {
	
	

	
	@Query(value="SELECT  g.fecha_gestion as fecha,u.usuario as usuario ,g.id_campana as campana ,eg.nombre as tipo, "
			+ "egs.nombre as subtipo,dg.observacion as observacion ,dg.num_real_marcado as numero "
			+ "from gestion g ,detalle_gestion dg , usuario u , estado_gestion eg , estado_gestion egs "
			+ "WHERE g.id_gestion =dg.id_gestion  AND g.id_agente =u.id_usuario AND dg.id_estado_gestion=egs.id_estado_gestion  "
			+ "AND g.id_estado_gestion =eg.id_estado_gestion  "
			+ "AND g.id_cliente= :idCliente ORDER BY g.fecha_gestion DESC ", nativeQuery = true)
	List<Object[]> buscarM(@Param("idCliente") Integer idCliente);
	
	@Query("FROM Gestion g where g.cliente.idCliente = :idCliente")
	List<Gestion> buscar(@Param("idCliente") Integer idCliente);
	
	@Query(value="SELECT u.usuario, case when eg.es_efectiva = true then 'efectiva' else 'noEfectiva' end as efectiva,  "
			+ "count(eg.es_efectiva) as cantidad  "
			+ "FROM detalle_gestion dg , estado_gestion eg, usuario u   "
			+ "WHERE dg.id_estado_gestion=eg.id_estado_gestion AND  dg.id_agente=u.id_usuario  "
			+ "AND  u.usuario= :loginAgente AND date(fecha_gestion)=(select current_date)  "
			+ "GROUP BY u.usuario, eg.es_efectiva  "
			+ "ORDER  BY efectiva", nativeQuery = true )
	List<Object[]> cantidadGestion(@Param("loginAgente") String loginAgente);

	}
