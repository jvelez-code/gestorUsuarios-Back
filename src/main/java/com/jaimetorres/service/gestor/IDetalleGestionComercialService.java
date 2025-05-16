package com.jaimetorres.service.gestor;


import java.util.List;


import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.GestionComercialDto;
import com.jaimetorres.model.gestor.DetalleGestionComercial;


public interface IDetalleGestionComercialService extends ICRUD<DetalleGestionComercial , Integer >{
	
	List<GestionComercialDto> buscarGC(ParametrosDTO filtro);
	//List<DetalleGestionComercial> buscarUsuarios(ParametrosDTO filtro);
	
}

