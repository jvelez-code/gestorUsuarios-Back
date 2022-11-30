package com.jaimetorres.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "extension")
public class Extension implements Serializable {
	
	private static final long serialVersionUID = 2048625916134304305L;

	@Id
	@Column(unique = true, nullable = false, length = 20)
	private String extension;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date duracionultimoestado;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaestado;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaultimoestado;
	
	@Column(nullable = true)
	private String extensionconectado;
	
	@Column(nullable = true)
	private Long espera;
	
	@Column
	private String monitoreo;
	
	@Column
	private String disponible;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "extension")
    private List<DetalleHorario> detalleHorarioList;
	
	@Transient
	private String labelDuracion;
	@Transient
	private String numeroLlamante;
	@Transient
	private String numeroLlamado;
	
	@JoinColumn(name = "empresa")
    @ManyToOne
    private Empresa empresa;

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Date getDuracionultimoestado() {
		return duracionultimoestado;
	}

	public void setDuracionultimoestado(Date duracionultimoestado) {
		this.duracionultimoestado = duracionultimoestado;
	}

	public Date getFechaestado() {
		return fechaestado;
	}

	public void setFechaestado(Date fechaestado) {
		this.fechaestado = fechaestado;
	}

	public Date getFechaultimoestado() {
		return fechaultimoestado;
	}

	public void setFechaultimoestado(Date fechaultimoestado) {
		this.fechaultimoestado = fechaultimoestado;
	}

	public String getExtensionconectado() {
		return extensionconectado;
	}

	public void setExtensionconectado(String extensionconectado) {
		this.extensionconectado = extensionconectado;
	}

	public Long getEspera() {
		return espera;
	}

	public void setEspera(Long espera) {
		this.espera = espera;
	}

	public String getMonitoreo() {
		return monitoreo;
	}

	public void setMonitoreo(String monitoreo) {
		this.monitoreo = monitoreo;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	public List<DetalleHorario> getDetalleHorarioList() {
		return detalleHorarioList;
	}

	public void setDetalleHorarioList(List<DetalleHorario> detalleHorarioList) {
		this.detalleHorarioList = detalleHorarioList;
	}

	public String getLabelDuracion() {
		return labelDuracion;
	}

	public void setLabelDuracion(String labelDuracion) {
		this.labelDuracion = labelDuracion;
	}

	public String getNumeroLlamante() {
		return numeroLlamante;
	}

	public void setNumeroLlamante(String numeroLlamante) {
		this.numeroLlamante = numeroLlamante;
	}

	public String getNumeroLlamado() {
		return numeroLlamado;
	}

	public void setNumeroLlamado(String numeroLlamado) {
		this.numeroLlamado = numeroLlamado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
