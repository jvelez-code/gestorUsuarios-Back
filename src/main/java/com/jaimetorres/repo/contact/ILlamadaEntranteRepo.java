package com.jaimetorres.repo.contact;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.dto.LlamadaEntranteDTO;
import com.jaimetorres.dto.TmoGestionUsuarioDto;
import com.jaimetorres.model.contact.LlamadaEntrante;


public interface ILlamadaEntranteRepo extends IGenericContactRepo< LlamadaEntrante , Integer >{

	@Query(value="SELECT  * FROM llamada_entrante le WHERE id_asterisk in ("
			+ "SELECT  callid  FROM queue_log ql WHERE id in ("
			+ "SELECT  MAX(ID) FROM queue_log ql WHERE agent = :nroDocumento AND event='CONNECT'))", nativeQuery = true)
	LlamadaEntrante buscarIdAsterisk(@Param("nroDocumento") String nroDocumento);

	@Query(value="SELECT  id_asterisk ,numero_documento,tipo_doc  "
			+ "FROM llamada_entrante le,tipo_documento td WHERE le.tipo_documento=td.id  "
			+ "AND id_asterisk in ( SELECT  callid  FROM queue_log ql WHERE id in "
			+ "( SELECT  MAX(ID) FROM queue_log ql WHERE agent = :nroDocumento AND event='CONNECT'))", nativeQuery = true)
	List<Object[]> buscarIdEntrante(@Param("nroDocumento") String nroDocumento);

	@Query(value="SELECT  callid  FROM queue_log ql WHERE id in ("
			+ "SELECT  MAX(ID) FROM queue_log ql WHERE agent = :nroDocumento )", nativeQuery = true)
	String LlamadaAsterisk(@Param("nroDocumento") String nroDocumento);

	@Query(value="SELECT event FROM queue_log "
			+ "WHERE time >= '2024-04-04 01:01:01' AND agent = :nroDocumento "
			+ "AND  event not in ('ADDMEMBER','REMOVEMEMBER','RINGNOANSWER') "
			+ "ORDER BY time DESC  LIMIT 1", nativeQuery = true)
	String validarAsterisk(@Param("nroDocumento") String nroDocumento);
	
	@Query(value="SELECT 	--c.agent,\n"
			+ "COALESCE(to_char(justify_interval(SUM(TO_TIMESTAMP(t.time, 'YYYY/MM/DD HH24:MI:SS') - TO_TIMESTAMP(c.time, 'YYYY/MM/DD HH24:MI:SS')) / COUNT(*)), 'HH24:MI:SS'), '00:00:00') AS tmoAgente \n"
			+ "--(sum(to_timestamp (t.time,'yyyy/mm/dd HH24:MI:ss')-to_timestamp (c.time,'yyyy/mm/dd HH24:MI:ss'))/count(*)) AS segundos \n"
			+ "FROM ( \n"
			+ "SELECT id,time,callid,agent,event \n"
			+ "FROM grabaciones_pila, queue_log \n"
			+ "WHERE uniqueid=callid AND id_agente=agent AND date(fecha_grabacion)=(select current_date) \n"
			+ "AND id_agente = :nroDocumento AND event='CONNECT'  \n"
			+ "AND tipo_de_llamada='Entrante') AS c \n"
			+ "INNER JOIN ( \n"
			+ "SELECT id,time,callid,agent,event \n"
			+ "FROM grabaciones_pila, queue_log \n"
			+ "WHERE uniqueid=callid and event IN ('COMPLETEAGENT','COMPLETECALLER','BLINDTRANSFER','ATTENDEDTRANSFER')) AS t ON c.callid=t.callid AND c.agent=t.agent \n"
			+ "INNER JOIN (SELECT DISTINCT(nro_documento), login_Agente \n"
			+ "FROM ask_estado_extension  WHERE activo=true \n"
			+ "GROUP BY login_Agente,nro_documento) ask ON c.agent=nro_documento \n", nativeQuery = true)
	Object[] validarTMO(@Param("nroDocumento") String nroDocumento);
		
	//SECRETARIA VIRTUAL
	
	@Query(value="SELECT * FROM llamada_entrante "
			+ " WHERE DATE(fecha_hora_asterisk) BETWEEN  current_date - integer '8' AND current_date "
			+ " AND empresa = :empresa and desea_devolucion  IS TRUE  "
			+ "	AND id_agente IS NULL AND numero_de_intentos_fallidos < 3  "
			+ "	AND id_detalle_gestion IS NULL "
			+ "	ORDER BY fecha_hora_asterisk  DESC LIMIT 1", nativeQuery = true)
	LlamadaEntrante secretariaVirtual(@Param("empresa") String empresa);
	
	@Transactional
	@Modifying	
	@Query(value="UPDATE llamada_entrante SET id_agente= :idAgente ,id_detalle_gestion='0' WHERE id_llamada_entrante = :idLlamadaEntrante ", nativeQuery = true)
    void cambioEstadoSecVirt(@Param("idAgente") Integer idAgente, @Param("idLlamadaEntrante") Integer idLlamadaEntrante);
	
	


}
