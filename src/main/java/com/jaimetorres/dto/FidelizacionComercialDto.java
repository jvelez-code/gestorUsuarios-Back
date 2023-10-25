package com.jaimetorres.dto;

import java.util.Date;

public class FidelizacionComercialDto {
	
	private Integer idFidelizacion;
	private Integer idDetalleGestionComercial;
	private Integer idCliente;
	private Integer idAgente;
	private String codCaja;
	private Integer regNuevos;
	private Integer regRecuperados;
	private Date fechaPago;
	private Long numPlanilla;
	private String observacion;
	private String migracion;
	private String sucursal;
	private Date fechaGestion;
	
	
	
	public FidelizacionComercialDto() {
		super();
	}
	

	public Integer getIdFidelizacion() {
		return idFidelizacion;
	}
	public void setIdFidelizacion(Integer idFidelizacion) {
		this.idFidelizacion = idFidelizacion;
	}
	public Integer getIdDetalleGestionComercial() {
		return idDetalleGestionComercial;
	}
	public void setIdDetalleGestionComercial(Integer idDetalleGestionComercial) {
		this.idDetalleGestionComercial = idDetalleGestionComercial;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdAgente() {
		return idAgente;
	}
	public void setIdAgente(Integer idAgente) {
		this.idAgente = idAgente;
	}
	public String getCodCaja() {
		return codCaja;
	}
	public void setCodCaja(String codCaja) {
		this.codCaja = codCaja;
	}
	public Integer getRegNuevos() {
		return regNuevos;
	}
	public void setRegNuevos(Integer regNuevos) {
		this.regNuevos = regNuevos;
	}
	public Integer getRegRecuperados() {
		return regRecuperados;
	}
	public void setRegRecuperados(Integer regRecuperados) {
		this.regRecuperados = regRecuperados;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Long getNumPlanilla() {
		return numPlanilla;
	}
	public void setNumPlanilla(Long numPlanilla) {
		this.numPlanilla = numPlanilla;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getMigracion() {
		return migracion;
	}
	public void setMigracion(String migracion) {
		this.migracion = migracion;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public Date getFechaGestion() {
		return fechaGestion;
	}
	public void setFechaGestion(Date fechaGestion) {
		this.fechaGestion = fechaGestion;
	}
	
	
	
	

}
