package com.jaimetorres.repo.gestor;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.CrmSubCategoria;


public interface ICrmSubCategoriaRepo extends IGenericRepo < CrmSubCategoria, Integer> {
	
	@Query("FROM CrmSubCategoria s JOIN s.idCategoria c WHERE c.idCategoria= :id")
	List<CrmSubCategoria> buscarSubcateR(@Param("id") Integer id);
	
	
	
	

}
