package com.jaimetorres.model.gestor;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 4109670930309584034L;
	

	@Id
	@SequenceGenerator(name = "Empleado.sequence", sequenceName = "empleado_id_empleado_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Empleado.sequence")	
	@Column(name = "id_empleado")
	private Integer idEmpleado;
	
	@ManyToOne
	@JoinColumn(name = "id_gestion")
	private Gestion gestion;
	
	@Column(name = "nro_documento")
	private String nroDocumento;
	
	@Column(name = "tipo_cotizante")
	private String tipoCotizante;
	
	@ManyToOne
	@JoinColumn(name = "tipo_documento")
	private TipoDocumento tipoDocumento;
	
	@Column(name = "nombre_completo")
	private String nombreCompleto;
	
	@Column(name = "estado_exclusion")
	private String estadoExclusion;

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Gestion getGestion() {
		return gestion;
	}

	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getTipoCotizante() {
		return tipoCotizante;
	}

	public void setTipoCotizante(String tipoCotizante) {
		this.tipoCotizante = tipoCotizante;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEstadoExclusion() {
		return estadoExclusion;
	}

	public void setEstadoExclusion(String estadoExclusion) {
		this.estadoExclusion = estadoExclusion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	

}
