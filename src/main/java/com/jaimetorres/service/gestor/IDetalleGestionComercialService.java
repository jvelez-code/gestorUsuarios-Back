package com.jaimetorres.service.gestor;


import java.util.List;


import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.GestionComercialDto;
import com.jaimetorres.model.gestor.DetalleGestionComercial;
import com.jaimetorres.model.gestor.Gestion;
import com.jaimetorres.model.gestor.Usuario;


public interface IDetalleGestionComercialService extends ICRUD<DetalleGestionComercial , Integer >{
	
	List<GestionComercialDto> buscarGC(ParametrosDTO filtro);
	List<DetalleGestionComercial> buscarUsuarios(ParametrosDTO filtro);
	
}

