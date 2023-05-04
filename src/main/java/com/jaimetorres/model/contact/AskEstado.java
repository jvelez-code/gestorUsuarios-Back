package com.jaimetorres.model.contact;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ask_estado")
public class AskEstado implements Serializable {	

	private static final long serialVersionUID = -5064617948110891469L;

	@Id 
	@Column(name="id_estado")
	private Integer idEstado;
	
	@Column(name="descripcion", nullable = false, unique = true)
	private String descripcion;
	
	@Column(name="color", nullable = false, unique = true)
	private String color;
		
	@Column(name="habilitado", nullable = false, unique = true)
	private Boolean habilitado;

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	
	
	

}
