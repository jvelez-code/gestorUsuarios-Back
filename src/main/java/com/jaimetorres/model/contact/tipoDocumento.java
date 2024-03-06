package com.jaimetorres.model.contact;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_documento")
public class tipoDocumento implements Serializable {		

	private static final long serialVersionUID = -5565030887782764243L;

	@Id 
	@Column(name="tipo_doc")
	private String tipoDoc;
	
	@Column(name="descripcion", nullable = false, unique = true)
	private String descripcion;
	
	@Column(name="id", nullable = false, unique = true)
	private Integer id;

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	}
