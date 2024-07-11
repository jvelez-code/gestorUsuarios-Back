package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "crm_subcategoria")
public class CrmSubCategoria implements Serializable {
	

	private static final long serialVersionUID = -1649422393569143205L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Subcategoria")
	private Integer idSubcategoria;	

    @Column(name = "nombre_subcategoria", length = 32, nullable = false)
	private String nombreSubCategoria;
	
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", foreignKey = @ForeignKey(name = "crm_subcategoria_categoria_fkey"))
   	private CrmCategoria idCategoria;

	public Integer getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(Integer idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}

	public String getNombreSubCategoria() {
		return nombreSubCategoria;
	}

	public void setNombreSubCategoria(String nombreSubCategoria) {
		this.nombreSubCategoria = nombreSubCategoria;
	}

	public CrmCategoria getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(CrmCategoria idCategoria) {
		this.idCategoria = idCategoria;
	}
    
    

	}
