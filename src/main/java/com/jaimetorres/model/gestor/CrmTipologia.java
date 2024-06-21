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
@Table(name = "crm_tipologia")
public class CrmTipologia implements Serializable {
	

	private static final long serialVersionUID = 6266336943223010675L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Tipologia")
	private Integer IdTipologia;	

    @Column(name = "nombre_Tipologia", length = 32, nullable = false)
	private String nombreTipologia;
	
    @ManyToOne
    @JoinColumn(name = "Id_Subcategoria", referencedColumnName = "Id_Subcategoria", foreignKey = @ForeignKey(name = "crm_tipologia_subcategoria_fkey"))
   	private CrmSubCategoria IdSubcategoria;

	public Integer getIdTipologia() {
		return IdTipologia;
	}

	public void setIdTipologia(Integer idTipologia) {
		IdTipologia = idTipologia;
	}

	public String getNombreCategoria() {
		return nombreTipologia;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreTipologia = nombreCategoria;
	}

	public CrmSubCategoria getIdSubcategoria() {
		return IdSubcategoria;
	}

	public void setIdSubcategoria(CrmSubCategoria idSubcategoria) {
		IdSubcategoria = idSubcategoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
