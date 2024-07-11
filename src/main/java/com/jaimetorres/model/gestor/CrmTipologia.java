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
	@Column(name = "id_Tipologia")
	private Integer idTipologia;	

    @Column(name = "nombre_Tipologia", length = 32, nullable = false)
	private String nombreTipologia;
	
    @ManyToOne
    @JoinColumn(name = "id_Subcategoria", referencedColumnName = "id_Subcategoria", foreignKey = @ForeignKey(name = "crm_tipologia_subcategoria_fkey"))
   	private CrmSubCategoria idSubcategoria;

	public Integer getIdTipologia() {
		return idTipologia;
	}

	public void setIdTipologia(Integer idTipologia) {
		this.idTipologia = idTipologia;
	}

	public String getNombreTipologia() {
		return nombreTipologia;
	}

	public void setNombreTipologia(String nombreTipologia) {
		this.nombreTipologia = nombreTipologia;
	}

	public CrmSubCategoria getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(CrmSubCategoria idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}
    
    

	}
