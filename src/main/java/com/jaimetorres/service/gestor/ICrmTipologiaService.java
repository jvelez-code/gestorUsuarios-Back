package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.model.gestor.CrmTipologia;

public interface ICrmTipologiaService extends ICRUD <CrmTipologia , Integer >{
	
	List<CrmTipologia> buscarTipoS(Integer id);
	

}
