package com.jaimetorres.repo.contact;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.contact.LlamadaEntrante;


public interface ILlamadaEntranteRepo extends IGenericContactRepo< LlamadaEntrante , Integer >{
	
	@Query(value="SELECT  * FROM llamada_entrante le WHERE id_asterisk in ("
			+ "SELECT  callid  FROM queue_log ql WHERE id in ("
			+ "SELECT  MAX(ID) FROM queue_log ql WHERE agent = :nroDocumento AND event='CONNECT'))", nativeQuery = true)
	LlamadaEntrante buscarIdAsterisk(@Param("nroDocumento") String nroDocumento);
	
	
	
	
}
