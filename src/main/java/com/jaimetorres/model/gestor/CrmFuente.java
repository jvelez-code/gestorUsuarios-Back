package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "crm_fuente")
public class CrmFuente implements Serializable {
	

	private static final long serialVersionUID = -7510986045147128041L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fuente")
	private Integer idFuente;	

    @Column(name = "nombre_fuente", length = 32, nullable = false)
	private String nombreFuente;

	public Integer getIdFuente() {
		return idFuente;
	}

	public void setIdFuente(Integer idFuente) {
		this.idFuente = idFuente;
	}

	public String getNombreFuente() {
		return nombreFuente;
	}

	public void setNombreFuente(String nombreFuente) {
		this.nombreFuente = nombreFuente;
	}

    


    

}
