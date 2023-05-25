package com.jaimetorres.dto;

import java.util.Date;

import javax.annotation.sql.DataSourceDefinition;

import com.jaimetorres.model.gestor.Campana;
import com.jaimetorres.model.gestor.Cliente;
import com.jaimetorres.model.gestor.Gestion;


public class FiltroDetalleGestionDTO {
	
	
	private String fecha;
	private String usuario;
	private String campana;
	private String tipo;
	private String subtipo;
	private String observacion;
	private String numero;
	
	public FiltroDetalleGestionDTO(String fecha, String usuario, String campana, String tipo, String subtipo,
			String observacion, String numero) {
		super();
		this.fecha = fecha;
		this.usuario = usuario;
		this.campana = campana;
		this.tipo = tipo;
		this.subtipo = subtipo;
		this.observacion = observacion;
		this.numero = numero;
	}
	public FiltroDetalleGestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCampana() {
		return campana;
	}
	public void setCampana(String campana) {
		this.campana = campana;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSubtipo() {
		return subtipo;
	}
	public void setSubtipo(String subtipo) {
		this.subtipo = subtipo;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
	
	

