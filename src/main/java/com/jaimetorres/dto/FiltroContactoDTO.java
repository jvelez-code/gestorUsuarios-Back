package com.jaimetorres.dto;


public class FiltroContactoDTO {
	
	private String nombre;
	private String correoElectronico;
	private String numeroContacto;
	private String telefonoDirecto;
	private String telefonoCelular;
	
	
	
	
	public FiltroContactoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FiltroContactoDTO(String nombre, String correoElectronico, String numeroContacto, String telefonoDirecto,
			String telefonoCelular) {
		super();
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.numeroContacto = numeroContacto;
		this.telefonoDirecto = telefonoDirecto;
		this.telefonoCelular = telefonoCelular;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getNumeroContacto() {
		return numeroContacto;
	}
	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	public String getTelefonoDirecto() {
		return telefonoDirecto;
	}
	public void setTelefonoDirecto(String telefonoDirecto) {
		this.telefonoDirecto = telefonoDirecto;
	}
	
	
	
	}
