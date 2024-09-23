package com.jaimetorres.dto;

import java.time.LocalDate;

public class FiltroCrmDetallesDTO {


	private Integer idDetalle;
	private Integer idCrmCaso;
	private Integer idUsuario;
	private String fechaDetalle;
	private String observacion;
	private String usuario;
	private Integer idCategoria;
	private Integer idCrmEstado;
	private Integer idCliente;
	
	
	
	public FiltroCrmDetallesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FiltroCrmDetallesDTO(Integer idDetalle, Integer idCrmCaso, Integer idUsuario, String fechaDetalle,
			String observacion, String usuario, Integer idCategoria, Integer idCrmEstado, Integer idCliente) {
		super();
		this.idDetalle = idDetalle;
		this.idCrmCaso = idCrmCaso;
		this.idUsuario = idUsuario;
		this.fechaDetalle = fechaDetalle;
		this.observacion = observacion;
		this.usuario = usuario;
		this.idCategoria = idCategoria;
		this.idCrmEstado = idCrmEstado;
		this.idCliente = idCliente;
	}



	public Integer getIdDetalle() {
		return idDetalle;
	}



	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}



	public Integer getIdCrmCaso() {
		return idCrmCaso;
	}



	public void setIdCrmCaso(Integer idCrmCaso) {
		this.idCrmCaso = idCrmCaso;
	}



	public Integer getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getFechaDetalle() {
		return fechaDetalle;
	}



	public void setFechaDetalle(String fechaDetalle) {
		this.fechaDetalle = fechaDetalle;
	}



	public String getObservacion() {
		return observacion;
	}



	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public Integer getIdCategoria() {
		return idCategoria;
	}



	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}



	public Integer getIdCrmEstado() {
		return idCrmEstado;
	}



	public void setIdCrmEstado(Integer idCrmEstado) {
		this.idCrmEstado = idCrmEstado;
	}



	public Integer getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

    

		
}



