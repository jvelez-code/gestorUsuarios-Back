package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.dto.estadoComercialDto;
import com.jaimetorres.model.gestor.EstadoGestion;


public interface IEstadoGestionService extends ICRUD<EstadoGestion , Integer >{
	
	List<EstadoGestion> buscar(ParametrosDTO filtro);
	List<EstadoGestion> buscarEstadoH(ParametrosDTO filtro);
	List<estadoComercialDto> gestionComercial(ParametrosDTO filtro);
	
	//Secretaria Virtual
	List<EstadoGestion> buscarSecretaria(ParametrosDTO filtro);

	//ADMINISTRACION DE ESTADOS
	List<EstadoGestion> busEstado(ParametrosDTO filtro);
	void activarEstado(ParametrosDTO filtro);
	List<EstadoGestion> busEstadoAct(ParametrosDTO filtro);
	List<EstadoGestion> busSubEstado(ParametrosDTO filtro);
	
	
}
