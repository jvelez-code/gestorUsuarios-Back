package com.jaimetorres.repo.gestor;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.CrmCategoria;

public interface ICrmCategoriaRepo extends IGenericRepo < CrmCategoria, Integer> {
	
	@Query("FROM CrmCategoria g WHERE g.idCategoria= :idCategoria ")
	CrmCategoria buscarVenci (@Param("idCategoria") Integer idCategoria);
	

}
