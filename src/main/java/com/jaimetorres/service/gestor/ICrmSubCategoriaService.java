package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.model.gestor.CrmSubCategoria;


public interface ICrmSubCategoriaService extends ICRUD < CrmSubCategoria , Integer >{
	
	List<CrmSubCategoria> buscarSubcateS(Integer id);
	

}
