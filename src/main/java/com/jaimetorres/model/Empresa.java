package com.jaimetorres.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 7144892449463328765L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
	
	
    @Column(name = "descripcion")
    private String descripcion;
    
    
    @Column(name = "pseudonimo")
    private String pseudonimo;


	public Integer getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getPseudonimo() {
		return pseudonimo;
	}


	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}
    
    


}
