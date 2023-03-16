package com.jaimetorres.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ia_gestion")
public class IAGestion implements Serializable{

	@Id
	@SequenceGenerator(name = "IAGestion.sequence", sequenceName = "ia_gestion_id_ia_gestion_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IAGestion.sequence")	
	@Column(name = "id_ia_gestion")
	private Integer idIAGestion;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "tipo_dato")
	private String tipoDato;
	
	@Column(name = "exp_reg")
	private String expReg;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_lista")
	private Lista lista;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_campana")
	private TipoCampana tipoCampana;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "es_visible")
	private Boolean visible;
	
	@Column(name = "es_editable")
	private Boolean editable;
	
	@Column(name = "es_parametro")
	private Boolean parametro;
	
	private String codigo;

	public Integer getIdIAGestion() {
		return idIAGestion;
	}

	public void setIdIAGestion(Integer idIAGestion) {
		this.idIAGestion = idIAGestion;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	public String getExpReg() {
		return expReg;
	}

	public void setExpReg(String expReg) {
		this.expReg = expReg;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public TipoCampana getTipoCampana() {
		return tipoCampana;
	}

	public void setTipoCampana(TipoCampana tipoCampana) {
		this.tipoCampana = tipoCampana;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Boolean getParametro() {
		return parametro;
	}

	public void setParametro(Boolean parametro) {
		this.parametro = parametro;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

}
