package com.jaimetorres.repo.gestor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.jaimetorres.model.gestor.Contacto;


public interface IContactoRepo extends IGenericRepo<Contacto, Integer> {
	
	
	@Query(" SELECT MAX(c.idContacto) FROM Contacto c WHERE c.cliente.idCliente= :idCliente")
	public Integer buscarMax(@Param("idCliente") Integer idCliente );
	
	@Query(" FROM Contacto c WHERE c.idContacto= :idContactoMax ")
	Contacto buscar(@Param("idContactoMax") Integer idContactoMax );
	
	//Saliente
	@Query(" FROM Contacto c WHERE c.gestion.idGestion= :idGestion ")
	Contacto buscarIdCont(@Param("idGestion") Integer idGestion );
	
	
	
	
//	
//	
//	@Query("FROM Contacto c WHERE c.fecha BETWEEN :fechaContacto AND :fechaSgte")
//	List<Contacto> buscarFecha(@Param("fechaContacto") LocalDateTime fechaContacto,@Param("fechaSgte") LocalDateTime fechaSgte);

}
