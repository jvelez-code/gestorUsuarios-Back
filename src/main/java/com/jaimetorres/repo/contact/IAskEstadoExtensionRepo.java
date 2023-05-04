package com.jaimetorres.repo.contact;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.contact.AskEstadoExtension;

public interface IAskEstadoExtensionRepo extends IGenericContactRepo< AskEstadoExtension , Integer >{
	
	@Query("FROM AskEstadoExtension c WHERE c.nroDocumento= :nroDocumento ")
	AskEstadoExtension buscar(@Param("nroDocumento") String nroDocumento);

	@Query("FROM AskEstadoExtension c WHERE c.loginAgente= :loginAgente ")
	AskEstadoExtension buscarAgente(@Param("loginAgente") String loginAgente);
	
	@Transactional
	@Modifying
	@Query("UPDATE AskEstadoExtension c SET c.estadoAsk= :estadoAsk, c.fechahoraInicioEstado = now(), c.numeroOrigen = null WHERE c.loginAgente= :loginAgente ") 
	void actualizarEstado(@Param("estadoAsk") Integer estadoAsk, @Param("loginAgente") String loginAgente);
	
	
}
