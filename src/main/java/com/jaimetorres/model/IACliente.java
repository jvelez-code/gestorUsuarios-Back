package com.jaimetorres.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ia_cliente")
public class IACliente implements Serializable {
	
	@Id
	@SequenceGenerator(name = "IACliente.sequence", sequenceName = "ia_cliente_id_ia_cliente_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IACliente.sequence")	
	
	@Column(name = "id_ia_cliente")
	private Integer idIACliente;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "tipo_dato")
	private String tipoDato;
	
	@Column(name = "exp_reg")
	private String expReg;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lista")
	private Lista lista;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_campana")
	private TipoCampana tipoCampana;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "es_editable")
	private Boolean editable;
	
	@Column(name = "es_visible")
	private Boolean visible;
	
	private String codigo;

	public Integer getIdIACliente() {
		return idIACliente;
	}

	public void setIdIACliente(Integer idIACliente) {
		this.idIACliente = idIACliente;
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

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

}
