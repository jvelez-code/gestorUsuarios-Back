package com.jaimetorres.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

//Captura las variables del front para gestion Entrante
public class ParametrosDTO {
	
	private String tipo;
	private String tipoDoc;
	private String loginAgente;
	private String nroDocumento;
	private Integer idCliente;
	private Integer idEmpresa;
	private Integer idTipoCampana;
	private Integer idEstadoPadre;
	private Integer tipoLlamada;
	private Integer idDetalleComer;
	private Integer cicloVida;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaInicial;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaFinal;
	
	
	public ParametrosDTO() {
	}

	
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}	
		
	public String getLoginAgente() {
		return loginAgente;
	}

	public void setLoginAgente(String loginAgente) {
		this.loginAgente = loginAgente;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Integer getIdEstadoPadre() {
		return idEstadoPadre;
	}
	public void setIdEstadoPadre(Integer idEstadoPadre) {
		this.idEstadoPadre = idEstadoPadre;
	}
	public Integer getIdTipoCampana() {
		return idTipoCampana;
	}
	public void setIdTipoCampana(Integer idTipoCampana) {
		this.idTipoCampana = idTipoCampana;
	}

	public Integer getTipoLlamada() {
		return tipoLlamada;
	}

	public void setTipoLlamada(Integer tipoLlamada) {
		this.tipoLlamada = tipoLlamada;
	}

	public Integer getIdDetalleComer() {
		return idDetalleComer;
	}

	public void setIdDetalleComer(Integer idDetalleComer) {
		this.idDetalleComer = idDetalleComer;
	}

	public Integer getCicloVida() {
		return cicloVida;
	}

	public void setCicloVida(Integer cicloVida) {
		this.cicloVida = cicloVida;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	
	
	
		

}
