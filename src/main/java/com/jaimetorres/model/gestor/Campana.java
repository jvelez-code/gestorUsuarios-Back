package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "campana")
public class Campana implements Serializable{

	private static final long serialVersionUID = 6595952258083192910L;

	@Id
	@SequenceGenerator(name = "Campana.sequence", sequenceName = "campana_id_campana_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Campana.sequence")	
	@Column(name = "id_campana")
	private Integer idCampana;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_campana")
	private TipoCampana tipoCampana;
	
	@ManyToOne
	@JoinColumn(name = "id_estado_campana")
	private EstadoCampana estadoCampana;
	
	@Column(name = "tiempo_cargue_campana")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tiempoCargueCampana;
	
	@Column(name = "fecha_hora_cargue")
	private String fechaHoraCargue;
	
//	@ManyToOne
//	@JoinColumn(name = "id_coordinador")
//	private Usuario coordinador;
	
	@Column(name = "id_coordinador")
	private Integer idCoordinador;
	
	
	@Column(name = "tipo_asignacion")
	private Integer tipoAsignacion;
	
	@Column(name = "grupo_rol")
	private String grupoRol;
	
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	
	@Column(name = "nombre")
	private String nombre;

	public Integer getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(Integer idCampana) {
		this.idCampana = idCampana;
	}

	public TipoCampana getTipoCampana() {
		return tipoCampana;
	}

	public void setTipoCampana(TipoCampana tipoCampana) {
		this.tipoCampana = tipoCampana;
	}

	public EstadoCampana getEstadoCampana() {
		return estadoCampana;
	}

	public void setEstadoCampana(EstadoCampana estadoCampana) {
		this.estadoCampana = estadoCampana;
	}

	public Date getTiempoCargueCampana() {
		return tiempoCargueCampana;
	}

	public void setTiempoCargueCampana(Date tiempoCargueCampana) {
		this.tiempoCargueCampana = tiempoCargueCampana;
	}

	public String getFechaHoraCargue() {
		return fechaHoraCargue;
	}

	public void setFechaHoraCargue(String fechaHoraCargue) {
		this.fechaHoraCargue = fechaHoraCargue;
	}

	public Integer getIdCoordinador() {
		return idCoordinador;
	}

	public void setIdCoordinador(Integer idCoordinador) {
		this.idCoordinador = idCoordinador;
	}

	public Integer getTipoAsignacion() {
		return tipoAsignacion;
	}

	public void setTipoAsignacion(Integer tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}

	public String getGrupoRol() {
		return grupoRol;
	}

	public void setGrupoRol(String grupoRol) {
		this.grupoRol = grupoRol;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	}
