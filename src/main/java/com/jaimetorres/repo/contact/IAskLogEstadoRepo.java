package com.jaimetorres.repo.contact;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.contact.AskLogEstado;

public interface IAskLogEstadoRepo extends IGenericContactRepo< AskLogEstado , Integer >{
	
	@Query("SELECT MAX(c.idLogEstado)FROM AskLogEstado c WHERE c.idExtension= :idExtension ")
	Integer buscar(@Param("idExtension") Integer idExtension);	
	
	@Transactional
	@Modifying
	@Query("UPDATE AskLogEstado c SET c.fechaHoraFinEstado=now() WHERE c.idLogEstado= :idLogEstado ") 
	void actualizarEstado(@Param("idLogEstado") Integer idLogEstado);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO ask_log_estados (id_log,id_extension,estado) VALUES ((select max(id_log)+1  from ask_log_estados), :idExtension, :estadoAsk)", nativeQuery = true)
	void registrar(@Param("idExtension") Integer idExtension, @Param("estadoAsk") Integer estadoAsk);
	
	
}
