package com.jaimetorres.repo;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.Contacto;


public interface IContactoRepo extends IGenericRepo<Contacto, Integer> {
	
	@Query("FROM Contacto c WHERE c.cliente.idCliente= :nroCliente ")
	List<Contacto> buscar(@Param("nroCliente") Integer nroCliente);
//	
//	
//	@Query("FROM Contacto c WHERE c.fecha BETWEEN :fechaContacto AND :fechaSgte")
//	List<Contacto> buscarFecha(@Param("fechaContacto") LocalDateTime fechaContacto,@Param("fechaSgte") LocalDateTime fechaSgte);

}
