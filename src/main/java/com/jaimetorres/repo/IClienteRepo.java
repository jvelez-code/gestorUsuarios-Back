package com.jaimetorres.repo;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.Cliente;
import com.jaimetorres.model.Gestion;


public interface IClienteRepo extends IGenericRepo<Cliente, Integer> {
	
	
	
	@Query("FROM Cliente c WHERE c.tipoDocumento.tipoDoc= :tipoDoc AND c.nroDocumento= :nroDocumento")
	Cliente buscar(@Param("tipoDoc") String tipoDoc,@Param("nroDocumento") String nroDocumento);
	
	
	@Query(value="SELECT * FROM cliente WHERE id_cliente= :nroCliente ", nativeQuery = true)
	List<Cliente> buscarByCliente(@Param("nroCliente") Integer nroCliente);
	
	@Query("FROM Cliente c WHERE c.idCliente= :nroCliente")
	List<Cliente> buscarByClientes(@Param("nroCliente") Integer nroCliente);
//	
//	
//	@Query("FROM Cliente c WHERE c.fecha BETWEEN :fechaCliente AND :fechaSgte")
//	List<Cliente> buscarFecha(@Param("fechaCliente") LocalDateTime fechaCliente,@Param("fechaSgte") LocalDateTime fechaSgte);

}
