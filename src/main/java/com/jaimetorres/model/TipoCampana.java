package com.jaimetorres.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tipo_campana")
public class TipoCampana implements Serializable{

	private static final long serialVersionUID = -7194328803124669078L;
	
	@Id	
	@SequenceGenerator(name = "TipoCampana.sequence", sequenceName = "tipo_campana_id_tipo_campana_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TipoCampana.sequence")	
	@Column(name = "id_tipo_campana")
	private Integer idTipoCampana;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "cod_tipo_campana")
	private String codTipoCampana;
	
	@Column(name = "tipo_llamada")
	private String tipoLlamada;

	public Integer getIdTipoCampana() {
		return idTipoCampana;
	}

	public void setIdTipoCampana(Integer idTipoCampana) {
		this.idTipoCampana = idTipoCampana;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodTipoCampana() {
		return codTipoCampana;
	}

	public void setCodTipoCampana(String codTipoCampana) {
		this.codTipoCampana = codTipoCampana;
	}

	public String getTipoLlamada() {
		return tipoLlamada;
	}

	public void setTipoLlamada(String tipoLlamada) {
		this.tipoLlamada = tipoLlamada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
