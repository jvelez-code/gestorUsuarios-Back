package com.jaimetorres.model.gestor;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "data_ia_gestion")
public class DataIAGestion implements Serializable {
	
	@Id
	@SequenceGenerator(name = "DataIAGestion.sequence", sequenceName = "data_ia_gestion_id_data_ia_gestion_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DataIAGestion.sequence")
	@Column(name = "id_data_ia_gestion")
	private Integer idDataIAGestion;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_gestion", nullable = false, foreignKey = @ForeignKey(name = "fk_contacto_gestion") )
	private Gestion gestion;
	
	
	@ManyToOne
	@JoinColumn(name = "id_ia_gestion")
	private IAGestion iaGestion;
	
	private String valor;

	public Integer getIdDataIAGestion() {
		return idDataIAGestion;
	}

	public void setIdDataIAGestion(Integer idDataIAGestion) {
		this.idDataIAGestion = idDataIAGestion;
	}

	public Gestion getGestion() {
		return gestion;
	}

	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

	public IAGestion getIaGestion() {
		return iaGestion;
	}

	public void setIaGestion(IAGestion iaGestion) {
		this.iaGestion = iaGestion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	

}
