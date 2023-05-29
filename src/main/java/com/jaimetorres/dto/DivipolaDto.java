package com.jaimetorres.dto;

public class DivipolaDto {

	private Integer idZona;
	private String nombre;
	private String departamento;
	
	
	public Integer getIdZona() {
		return idZona;
	}



	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDepartamento() {
		return departamento;
	}



	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}



	public DivipolaDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DivipolaDto(Integer idZona, String nombre, String departamento) {
		super();
		this.idZona = idZona;
		this.nombre = nombre;
		this.departamento = departamento;
	}
	
	
	
}
