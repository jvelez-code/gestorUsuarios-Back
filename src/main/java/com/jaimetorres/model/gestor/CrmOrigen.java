package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "crm_origen")
public class CrmOrigen implements Serializable {
	
	private static final long serialVersionUID = 7340011977952407721L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_origen")
	private Integer idOrigen;	

    @Column(name = "nombre_origen", length = 32, nullable = false)
	private String nombreOrigen;

	public Integer getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}

	public String getNombreOrigen() {
		return nombreOrigen;
	}

	public void setNombreOrigen(String nombreOrigen) {
		this.nombreOrigen = nombreOrigen;
	}
    
    

	}
