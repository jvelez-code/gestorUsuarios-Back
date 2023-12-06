package com.jaimetorres.repo.contact;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.dto.LlamadaEntranteDTO;
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
			+ "WHERE agent = :nroDocumento "
			+ "AND  event not in ('ADDMEMBER','REMOVEMEMBER','RINGNOANSWER') "
			+ "ORDER BY time DESC  LIMIT 1", nativeQuery = true)
	String validarAsterisk(@Param("nroDocumento") String nroDocumento);

	@Query(value="SELECT CAST((SUM(date_trunc('second',(cast(t.time as time)))- "
			+ "	date_trunc('second',cast(c.time as time)))/count(*)) AS TIME ) "
			+ " FROM ( SELECT time,callid,agent,event FROM grabaciones_pila, queue_log "
			+ "	WHERE uniqueid=callid AND id_agente=agent AND date(fecha_grabacion)='2023-11-21' "
			+ " and event='CONNECT' AND id_agente=:nroDocumento AND tipo_de_llamada='Entrante') AS c  "
			+ "	INNER JOIN (SELECT time,callid,agent,event  "
			+ " FROM queue_log WHERE event IN ('COMPLETEAGENT','COMPLETECALLER','BLINDTRANSFER','ATTENDEDTRANSFER')) "
			+ " AS t ON c.callid=t.callid  "
			+ "	AND c.agent=t.agent", nativeQuery = true)
	Date validarTMO(@Param("nroDocumento") String nroDocumento);




}
