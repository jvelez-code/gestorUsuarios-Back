package com.jaimetorres.dto;

public class CantidadGestionDto {

	private String cantidad;
	private String usuario;
	private String efectiva;
	

	


	public CantidadGestionDto(String cantidad, String usuario, String efectiva) {
		super();
		this.cantidad = cantidad;
		this.usuario = usuario;
		this.efectiva = efectiva;
	}
	
	
	public CantidadGestionDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEfectiva() {
		return efectiva;
	}
	public void setEfectiva(String efectiva) {
		this.efectiva = efectiva;
	}
	
	
	
	}
