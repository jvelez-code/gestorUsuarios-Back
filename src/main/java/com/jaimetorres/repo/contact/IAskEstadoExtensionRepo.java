package com.jaimetorres.repo.contact;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.contact.AskEstadoExtension;

public interface IAskEstadoExtensionRepo extends IGenericContactRepo< AskEstadoExtension , Integer >{
	
	@Query("FROM AskEstadoExtension c WHERE c.nroDocumento= :nroDocumento ")
	AskEstadoExtension buscar(@Param("nroDocumento") String nroDocumento);

}
