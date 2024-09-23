package com.jaimetorres.dto;


public class FiltroDetalleGestionDTO {


	private String fecha;
	private String usuario;
	private String campana;
	private String tipo;
	private String subtipo;
	private String observacion;
	private String numero;
	private Integer idGestion;
	private Integer idAgente;
	private Integer idEstadoGestion;
	private String usuarioAct;
	private String ipAct;
	private String extension;


	public FiltroDetalleGestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public FiltroDetalleGestionDTO(String fecha, String usuario, String campana, String tipo, String subtipo,
			String observacion, String numero, Integer idGestion, Integer idAgente, Integer idEstadoGestion,
			String usuarioAct, String ipAct, String extension) {
		super();
		this.fecha = fecha;
		this.usuario = usuario;
		this.campana = campana;
		this.tipo = tipo;
		this.subtipo = subtipo;
		this.observacion = observacion;
		this.numero = numero;
		this.idGestion = idGestion;
		this.idAgente = idAgente;
		this.idEstadoGestion = idEstadoGestion;
		this.usuarioAct = usuarioAct;
		this.ipAct = ipAct;
		this.extension = extension;
	}




	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCampana() {
		return campana;
	}
	public void setCampana(String campana) {
		this.campana = campana;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSubtipo() {
		return subtipo;
	}
	public void setSubtipo(String subtipo) {
		this.subtipo = subtipo;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}




	public Integer getIdGestion() {
		return idGestion;
	}




	public void setIdGestion(Integer idGestion) {
		this.idGestion = idGestion;
	}




	public Integer getIdAgente() {
		return idAgente;
	}




	public void setIdAgente(Integer idAgente) {
		this.idAgente = idAgente;
	}




	public Integer getIdEstadoGestion() {
		return idEstadoGestion;
	}




	public void setIdEstadoGestion(Integer idEstadoGestion) {
		this.idEstadoGestion = idEstadoGestion;
	}




	public String getUsuarioAct() {
		return usuarioAct;
	}




	public void setUsuarioAct(String usuarioAct) {
		this.usuarioAct = usuarioAct;
	}




	public String getIpAct() {
		return ipAct;
	}




	public void setIpAct(String ipAct) {
		this.ipAct = ipAct;
	}




	public String getExtension() {
		return extension;
	}




	public void setExtension(String extension) {
		this.extension = extension;
	}



}