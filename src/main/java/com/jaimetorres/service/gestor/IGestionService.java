package com.jaimetorres.service.gestor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.jaimetorres.dto.CargueArchivoDTO;
import com.jaimetorres.dto.LlamadaEntranteDTO;
import com.jaimetorres.dto.ParametrosDTO;
import com.jaimetorres.model.gestor.Contacto;
import com.jaimetorres.model.gestor.DetalleGestion;
import com.jaimetorres.model.gestor.Gestion;
import com.opencsv.exceptions.CsvValidationException;


public interface IGestionService extends ICRUD<Gestion , Integer >{
	
	Gestion registrarTransaccional(Gestion gestion) throws Exception;
	
	//Gestion C0mercial
	Gestion registrarTransaccionalComercial(Gestion gestion) throws Exception;
	void actuaGestionComer( Integer idGestion, DetalleGestion detalleGestion);
	
	List<Gestion> buscar(ParametrosDTO filtro);
	
	List<Gestion> buscarA(ParametrosDTO filtro);	
	Gestion buscarM(ParametrosDTO filtro);
	
	//GESTION SALIENTE
	Integer gestionSaliente(ParametrosDTO filtro);
	
	void cambioEstadoGestion(Integer idGestion);
	ParametrosDTO buscarGestioSaliente(Integer idgestion);
	void actualizarGestion(Integer id, Gestion gestion);
	
	String getClientIp(HttpServletRequest request);
	
	//CARGUE CAMPANA
	ParametrosDTO readCsvFile(
			MultipartFile file,
			String idUsuario,
			String idEmpresa,
			HttpServletRequest request ) throws IOException, CsvValidationException;
	
	Gestion registrarTransaccionalCargue(Gestion gestion) throws Exception;
	
	
	// SECRETARIA VIRTUAL
	Integer buscarSecre(LlamadaEntranteDTO filtro);
	

}