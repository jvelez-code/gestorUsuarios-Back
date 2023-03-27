package com.jaimetorres.dto;

public class FiltroEntranteDTO {
	
	private String tipoDoc;
	private String nroDocumento;
	private Integer idCliente;
	private Integer idEmpresa;
	private Integer idTipoCampana;
	private Integer idEstadoPadre;
	private Integer tipoLlamada;
	
	
	public FiltroEntranteDTO() {
	}

	
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
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
	
	
	
	
		

}
