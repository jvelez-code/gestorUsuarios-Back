package com.jaimetorres.repo;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.Cliente;
import com.jaimetorres.model.TipoDocumento;


public interface ITipoDocumentoRepo extends IGenericRepo<TipoDocumento, Integer> {
	
//	@Query("FROM Cliente c WHERE c.tipoDocumento.tipoDoc= :tipoDoc AND c.nroDocumento= :nroDocumento")
//	List<Cliente> buscar(@Param("tipoDoc") String tipoDoc,@Param("nroDocumento") String nroDocumento);
//	
//	
//	@Query("FROM Cliente c WHERE c.fecha BETWEEN :fechaCliente AND :fechaSgte")
//	List<Cliente> buscarFecha(@Param("fechaCliente") LocalDateTime fechaCliente,@Param("fechaSgte") LocalDateTime fechaSgte);

}
