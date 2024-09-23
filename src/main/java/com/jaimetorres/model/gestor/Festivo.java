package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "festivos")
public class Festivo implements Serializable {	

	private static final long serialVersionUID = 7944164271446287392L;
	
    @Id
	@Column(name = "fecha")
	private String fecha;	

    @Column(name = "empresa")
	private Integer empresa;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}  
    
    
    
	}
