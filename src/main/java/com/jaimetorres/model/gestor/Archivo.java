package com.jaimetorres.model.gestor;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "archivo")
public class Archivo implements Serializable{

	private static final long serialVersionUID = -5974418014073831873L;
	
	@Id
	@SequenceGenerator(name = "Archivo.sequence", sequenceName = "archivo_id_archivo_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Archivo.sequence")	
	@Column(name = "id_archivo")
	private Integer idArchivo;
	
	@ManyToOne
	@JoinColumn(name = "id_campana")
	private Campana campana;
	
	@Column(name = "usuario_cargue")
	private String usuarioCargue;
	
	@Column(name = "nombre_archivo")
	private String nombreArchivo;
	
	@Column(name = "cantidad_registros")
	private Integer cantidadRegistros;
	
	@Column(name = "fecha_hora_cargue")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaHoraCargue;
	
	@Column(name = "registros_exitosos")
	private Integer registrosExitosos;
	
	@Column(name = "registros_error")
	private Integer registrosError;
	
	@Column(name = "operacion")
	private String operacion;

	public Integer getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}

	public Campana getCampana() {
		return campana;
	}

	public void setCampana(Campana campana) {
		this.campana = campana;
	}

	public String getUsuarioCargue() {
		return usuarioCargue;
	}

	public void setUsuarioCargue(String usuarioCargue) {
		this.usuarioCargue = usuarioCargue;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Integer getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(Integer cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public LocalDateTime getFechaHoraCargue() {
		return fechaHoraCargue;
	}

	public void setFechaHoraCargue(LocalDateTime fechaHoraCargue) {
		this.fechaHoraCargue = fechaHoraCargue;
	}

	public Integer getRegistrosExitosos() {
		return registrosExitosos;
	}

	public void setRegistrosExitosos(Integer registrosExitosos) {
		this.registrosExitosos = registrosExitosos;
	}

	public Integer getRegistrosError() {
		return registrosError;
	}

	public void setRegistrosError(Integer registrosError) {
		this.registrosError = registrosError;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	

	
}
