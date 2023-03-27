package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "motivo")
public class Motivo implements Serializable {

	private static final long serialVersionUID = 2714769007470402441L;
	
	@Id
	@Column(name = "id_motivo")
	private Integer idMotivo;
	
	@Column(name = "nombre")
	private String nombre;

	public Integer getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(Integer idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
