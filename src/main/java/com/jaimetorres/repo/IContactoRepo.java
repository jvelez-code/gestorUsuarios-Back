package com.jaimetorres.repo;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.dto.FiltroContactoDTO;
import com.jaimetorres.model.Cliente;
import com.jaimetorres.model.Contacto;


public interface IContactoRepo extends IGenericRepo<Contacto, Integer> {
	
	
	@Query(" SELECT MAX(c.idContacto) FROM Contacto c WHERE c.cliente.idCliente= :idCliente")
	public Integer buscarMax(@Param("idCliente") Integer idCliente );
	
	@Query(" FROM Contacto c WHERE c.idContacto= :idContactoMax ")
	List<Contacto> buscar(@Param("idContactoMax") Integer idContactoMax );
	
	
//	
//	
//	@Query("FROM Contacto c WHERE c.fecha BETWEEN :fechaContacto AND :fechaSgte")
//	List<Contacto> buscarFecha(@Param("fechaContacto") LocalDateTime fechaContacto,@Param("fechaSgte") LocalDateTime fechaSgte);

}
