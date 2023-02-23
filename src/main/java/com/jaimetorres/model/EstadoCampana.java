package com.jaimetorres.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "estado_campana")
public class EstadoCampana implements Serializable{

	private static final long serialVersionUID = -7270914288083957183L;
	
	@Id	
	@Column(name = "id_estado_campana")
	private Integer idEstadoCampana;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "es_estado_final")
	private Boolean estadoFinal;

	public Integer getIdEstadoCampana() {
		return idEstadoCampana;
	}

	public void setIdEstadoCampana(Integer idEstadoCampana) {
		this.idEstadoCampana = idEstadoCampana;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(Boolean estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	

}
