package com.jaimetorres.dto;

public class FiltroEstadoDTO {
	
	
	private Integer idExtension;
	private String loginAgente;
	private Integer nroDocumento;
	private Integer estadoAsk;
	
	
	
	public FiltroEstadoDTO() {
	}
	
	public Integer getIdExtension() {
		return idExtension;
	}
	public void setIdExtension(Integer idExtension) {
		this.idExtension = idExtension;
	}
	public String getLoginAgente() {
		return loginAgente;
	}
	public void setLoginAgente(String loginAgente) {
		this.loginAgente = loginAgente;
	}	
	public Integer getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public Integer getEstadoAsk() {
		return estadoAsk;
	}
	public void setEstadoAsk(Integer estadoAsk) {
		this.estadoAsk = estadoAsk;
	}
	
	
	
	
	

}
