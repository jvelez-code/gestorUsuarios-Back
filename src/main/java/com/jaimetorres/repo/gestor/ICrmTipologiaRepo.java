package com.jaimetorres.repo.gestor;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jaimetorres.model.gestor.CrmTipologia;


public interface ICrmTipologiaRepo extends IGenericRepo < CrmTipologia, Integer> {
	
	@Query("FROM CrmTipologia t JOIN t.idSubcategoria s WHERE s.idSubcategoria= :id")
	List<CrmTipologia> buscarTipoR(@Param("id") Integer id);
	

}
