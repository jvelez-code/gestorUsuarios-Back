package com.jaimetorres.dto;

import java.util.Date;

import javax.annotation.sql.DataSourceDefinition;

import com.jaimetorres.model.Campana;
import com.jaimetorres.model.Cliente;
import com.jaimetorres.model.Gestion;


public class FiltroDetalleGestionDTO {
	
	private Integer idDetalleGestion;
	private Integer estadoGestion;
	private String usuarioAct;
	private Date fechaHoraSis;
	private String observacion;
	private String numRealMarcado;
	private Integer idEmpresa;
	
	
	
	public FiltroDetalleGestionDTO() {
		super();
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}




	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}




	public Integer getIdDetalleGestion() {
		return idDetalleGestion;
	}


	public void setIdDetalleGestion(Integer idDetalleGestion) {
		this.idDetalleGestion = idDetalleGestion;
	}


	public Integer getEstadoGestion() {
		return estadoGestion;
	}


	public void setEstadoGestion(Integer estadoGestion) {
		this.estadoGestion = estadoGestion;
	}


	public String getUsuarioAct() {
		return usuarioAct;
	}


	public void setUsuarioAct(String usuario_act) {
		this.usuarioAct = usuario_act;
	}


	public Date getFechaHoraSis() {
		return fechaHoraSis;
	}


	public void setFechaHoraSis(Date fechaHoraSis) {
		this.fechaHoraSis = fechaHoraSis;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getNumRealMarcado() {
		return numRealMarcado;
	}


	public void setNumRealMarcado(String numRealMarcado) {
		this.numRealMarcado = numRealMarcado;
	}
	
	
	

	}
	
	

