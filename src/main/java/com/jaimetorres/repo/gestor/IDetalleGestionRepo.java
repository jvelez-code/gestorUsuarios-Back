package com.jaimetorres.repo.gestor;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.dto.CantidadGestionDto;
import com.jaimetorres.dto.FiltroDetalleGestionDTO;
import com.jaimetorres.dto.tmoGestionDto;
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
			+ "FROM gestion dg , estado_gestion eg, usuario u   "
			+ "WHERE dg.id_estado_gestion=eg.id_estado_gestion AND  dg.id_agente=u.id_usuario  "
			+ "AND  u.usuario= :loginAgente AND date(fecha_gestion)=(select current_date)  "
			+ "GROUP BY u.usuario, eg.es_efectiva  "
			+ "ORDER  BY efectiva", nativeQuery = true )
	List<Object[]> cantidadGestion(@Param("loginAgente") String loginAgente);
	
	@Query(value="SELECT "
			+ "c.agent AS agent, "
			+ "login_Agente AS agente, "
			+ "sum(to_timestamp (t.time,'yyyy/mm/dd HH24:MI:ss')::time-to_timestamp (c.time,'yyyy/mm/dd HH24:MI:ss')::time) AS duracionLlamadas, "
			+ "count(*) as cantidadGrabaciones, "
			+ "SUBSTRING((sum(to_timestamp (t.time,'yyyy/mm/dd HH24:MI:ss')::time-to_timestamp (c.time,'yyyy/mm/dd HH24:MI:ss')::time)/count(*))::TEXT,0,9) AS segundos "
			+ "FROM ( "
			+ "SELECT time,callid,agent,event "
			+ "FROM grabaciones_pila, queue_log "
			+ "WHERE uniqueid=callid AND id_agente=agent AND date(fecha_grabacion)=(select current_date) "
			+ "AND id_agente='1023026686' AND event='CONNECT'  "
			+ "AND tipo_de_llamada='Entrante') AS c "
			+ "INNER JOIN ( "
			+ "SELECT time,callid,agent,event "
			+ "FROM grabaciones_pila, queue_log "
			+ "WHERE uniqueid=callid and event IN ('COMPLETEAGENT','COMPLETECALLER','BLINDTRANSFER','ATTENDEDTRANSFER')) AS t ON c.callid=t.callid AND c.agent=t.agent "
			+ "INNER JOIN (SELECT DISTINCT(nro_documento), login_Agente "
			+ "FROM ask_estado_extension  WHERE activo=true GROUP BY  login_Agente,nro_documento) ask ON c.agent=nro_documento "
			+ "GROUP BY c.agent,login_Agente "
			+ "ORDER BY c.agent,login_Agente", nativeQuery = true )
	List<tmoGestionDto> tmoGestion(@Param("loginAgente") String loginAgente);

	}
