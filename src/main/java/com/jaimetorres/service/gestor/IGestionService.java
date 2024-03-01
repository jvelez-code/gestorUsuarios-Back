package com.jaimetorres.service.gestor;

import java.util.List;

import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.Gestion;


public interface IGestionService extends ICRUD<Gestion , Integer >{
	
	Gestion registrarTransaccional(Gestion gestion) throws Exception;
	
	//Gestion C0mercial
	Gestion registrarTransaccionalComercial(Gestion gestion) throws Exception;
	void actuaGestionComer( Integer idGestion, DetalleGestion detalleGestion);
	
	List<Gestion> buscar(ParametrosDTO filtro);
	
	List<Gestion> buscarA(ParametrosDTO filtro);	
	Gestion buscarM(ParametrosDTO filtro);
	
	// Gestion Saliente
	Integer gestionSaliente(ParametrosDTO filtro);
	void cambioEstadoGestion(Integer idGestion);
	ParametrosDTO buscarGestioSaliente(Integer idgestion);
	void actualizarGestion(Integer id, Gestion gestion);
}