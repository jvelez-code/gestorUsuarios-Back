package com.jaimetorres.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "estado_gestion")
public class EstadoGestion implements Serializable {

	private static final long serialVersionUID = -7355194626370500329L;
	
	@Id
	@Column(name = "id_estado_gestion")
	private Integer idEstadoGestion;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "id_estado_gestion_padre")
	private Integer idEstadoGestionPadre;
	
	@Column(name = "aplica_dg")
	private Boolean aplicaDG;
	
	@Column(name = "es_estado_final")
	private Boolean estadoFinal;
	
	@Column(name = "es_efectiva")
	private Boolean esEfectiva;
	
	@Column(name = "permite_cambio")
	private Boolean permiteCambio;
	
	@Column(name = "tipo_llamada")
	private Integer tipoLlamada;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", insertable=false, updatable=false)
	private Empresa idEmpresa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado_gestion_padre", insertable=false, updatable=false)
	private EstadoGestion estadoGestionPadre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_campana", insertable=false, updatable=false)
	private TipoCampana tipoCampana;

	public Integer getIdEstadoGestion() {
		return idEstadoGestion;
	}

	public void setIdEstadoGestion(Integer idEstadoGestion) {
		this.idEstadoGestion = idEstadoGestion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdEstadoGestionPadre() {
		return idEstadoGestionPadre;
	}

	public void setIdEstadoGestionPadre(Integer idEstadoGestionPadre) {
		this.idEstadoGestionPadre = idEstadoGestionPadre;
	}

	public Boolean getAplicaDG() {
		return aplicaDG;
	}

	public void setAplicaDG(Boolean aplicaDG) {
		this.aplicaDG = aplicaDG;
	}

	public Boolean getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(Boolean estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public Boolean getEsEfectiva() {
		return esEfectiva;
	}

	public void setEsEfectiva(Boolean esEfectiva) {
		this.esEfectiva = esEfectiva;
	}

	public Boolean getPermiteCambio() {
		return permiteCambio;
	}

	public void setPermiteCambio(Boolean permiteCambio) {
		this.permiteCambio = permiteCambio;
	}

	public Integer getTipoLlamada() {
		return tipoLlamada;
	}

	public void setTipoLlamada(Integer tipoLlamada) {
		this.tipoLlamada = tipoLlamada;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public EstadoGestion getEstadoGestionPadre() {
		return estadoGestionPadre;
	}

	public void setEstadoGestionPadre(EstadoGestion estadoGestionPadre) {
		this.estadoGestionPadre = estadoGestionPadre;
	}

	public TipoCampana getTipoCampana() {
		return tipoCampana;
	}

	public void setTipoCampana(TipoCampana tipoCampana) {
		this.tipoCampana = tipoCampana;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	

}
