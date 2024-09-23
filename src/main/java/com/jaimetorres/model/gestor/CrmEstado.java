package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crm_estado")
public class CrmEstado implements Serializable {
	
	
	private static final long serialVersionUID = 7077287725021279571L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	private Integer idEstado;	

    @Column(name = "nombre_estado", length = 32, nullable = false)
	private String nombreEstado;

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
	
}
