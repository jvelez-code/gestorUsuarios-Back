package com.jaimetorres.repo.contact;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.dto.LlamadaEntranteDTO;
import com.jaimetorres.model.contact.LlamadaEntrante;




public interface ILlamadaEntranteRepo extends IGenericContactRepo< LlamadaEntrante , Integer >{

	@Query(value="SELECT  * FROM llamada_entrante le WHERE id_asterisk in ("
			+ "SELECT  callid  FROM queue_log ql WHERE id in ("
			+ "SELECT  MAX(ID) FROM queue_log ql WHERE agent = :nroDocumento AND event='CONNECT'))", nativeQuery = true)
	LlamadaEntrante buscarIdAsterisk(@Param("nroDocumento") String nroDocumento);

	@Query(value = "SELECT le.id_asterisk as idAsterisk, le.numero_documento as numeroDocumento, td.tipo_doc as tipoDoc, "
			+ "le.id_asterisk as tmoUsuario, le.empresa as empresa "
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
	Optional<String> validarTMO(@Param("nroDocumento") String nroDocumento);
		
	//SECRETARIA VIRTUAL
	
	@Query(value="SELECT * FROM llamada_entrante "
			+ " WHERE DATE(fecha_hora_asterisk) BETWEEN  current_date - integer '8' AND current_date "
			+ " AND empresa = :empresa and id_agente IS NULL "
			+ "	AND desea_devolucion= TRUE AND numero_de_intentos_fallidos < 3  "
			+ "	AND id_detalle_gestion IS NULL "
			+ "	ORDER BY fecha_hora_asterisk  DESC LIMIT 1", nativeQuery = true)
	LlamadaEntrante secretariaVirtual(@Param("empresa") String empresa);
	
	@Transactional
	@Modifying	
	@Query(value="UPDATE llamada_entrante set desea_devolucion =false, id_detalle_gestion='2' "
			+ "	WHERE DATE(fecha_hora_asterisk) BETWEEN  current_date - integer '8' AND current_date "
			+ "	AND desea_devolucion= TRUE "
			+ "	AND id_detalle_gestion IS NULL and numero_documento = :numeroDocumento and id_llamada_entrante <> :idLlamadaEntrante", nativeQuery = true)
	void limpiarSecretaria(@Param("numeroDocumento") String numeroDocumento, @Param("idLlamadaEntrante") Integer idLlamadaEntrante);
	
	@Transactional
	@Modifying	
	@Query(value="UPDATE llamada_entrante SET id_agente= :idAgente ,id_detalle_gestion='1', fecha_devolucion = now(), fecha_hora =now() "
			+ " WHERE id_llamada_entrante = :idLlamadaEntrante ", nativeQuery = true)
    void cambioEstadoSecVirt(@Param("idAgente") Integer idAgente, @Param("idLlamadaEntrante") Integer idLlamadaEntrante);
	
	@Transactional
	@Modifying	
	@Query(value="UPDATE llamada_entrante SET id_agente = NULL ,id_detalle_gestion= NULL, fecha_devolucion = null, fecha_hora =fecha_hora_asterisk "
			+ "WHERE id_llamada_entrante = :idLlamadaEntrante ", nativeQuery = true)
    void devolverEstadoSecVirt(@Param("idLlamadaEntrante") Integer idLlamadaEntrante);
	
	


}
