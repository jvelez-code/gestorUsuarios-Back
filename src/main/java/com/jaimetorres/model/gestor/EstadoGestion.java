package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "estado_gestion")
public class EstadoGestion implements Serializable {

	private static final long serialVersionUID = -7355194626370500329L;
	
	@Id
	@SequenceGenerator(name = "EstadoGestion.sequence", sequenceName = "estado_gestion_id_estado_gestion_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EstadoGestion.sequence")
	@Column(name = "id_estado_gestion")
	private Integer idEstadoGestion;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "id_estado_gestion_padre")
	private Integer idEstadoGestionPadre;
	
	@Column(name = "aplica_dg")
	private Boolean aplicaDG = true;

	@Column(name = "es_estado_final")
	private Boolean estadoFinal = true; 

	@Column(name = "es_efectiva")
	private Boolean esEfectiva = true;  

	@Column(name = "permite_cambio")
	private Boolean permiteCambio = false;
	
	@Column(name = "tipo_llamada")
	private Integer tipoLlamada;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false, foreignKey =  @ForeignKey(name = "fk_idempresa"))
	private Empresa empresa;

//	@ManyToOne
//	@JoinColumn(name = "id_estado_gestion_padre", insertable=false, updatable=false)
//	private EstadoGestion estadoGestionPadre;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_campana", nullable = false, foreignKey =  @ForeignKey(name = "fk_estado_campana_tipo_campana"))
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

//	public EstadoGestion getEstadoGestionPadre() {
//		return estadoGestionPadre;
//	}
//
//	public void setEstadoGestionPadre(EstadoGestion estadoGestionPadre) {
//		this.estadoGestionPadre = estadoGestionPadre;
//	}

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
