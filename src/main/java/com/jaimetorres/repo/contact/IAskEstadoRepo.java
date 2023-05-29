package com.jaimetorres.repo.contact;



import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.jaimetorres.model.contact.AskEstado;


public interface IAskEstadoRepo extends IGenericContactRepo< AskEstado , Integer >{
	
	@Query("FROM AskEstado c WHERE c.habilitado= true ORDER BY c.idEstado")
	List<AskEstado> buscar();

	

	
}
