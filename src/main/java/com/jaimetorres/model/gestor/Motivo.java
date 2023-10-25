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

	public Motivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Motivo(Integer idMotivo, String nombre) {
		super();
		this.idMotivo = idMotivo;
		this.nombre = nombre;
	}



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
	
	
	
	
	

}
