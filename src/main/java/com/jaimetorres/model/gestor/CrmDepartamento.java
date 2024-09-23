package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "crm_departamento")
public class CrmDepartamento implements Serializable {
	
	private static final long serialVersionUID = 9059483652758359255L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
	private Integer idDepartamento;	

    @Column(name = "nombre_departamento", length = 32, nullable = false)
	private String nombreDepartamento;

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}



      
    
	}
