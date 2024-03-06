package com.jaimetorres.dto;


public class LlamadaEntranteDTO {
	
	private String idAsterisk;
	private String numero_documento;
	private String tipo_doc;
	private String tmoUsuario;
	private String empresa;
	private Integer idLlamadaEntrante;
	private Integer idAgente;

	public LlamadaEntranteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public LlamadaEntranteDTO(String idAsterisk, String numero_documento, String tipo_doc, String tmoUsuario,
			String empresa, Integer idLlamadaEntrante, Integer idAgente) {
		super();
		this.idAsterisk = idAsterisk;
		this.numero_documento = numero_documento;
		this.tipo_doc = tipo_doc;
		this.tmoUsuario = tmoUsuario;
		this.empresa = empresa;
		this.idLlamadaEntrante = idLlamadaEntrante;
		this.idAgente = idAgente;
	}


	public String getidAsterisk() {
		return idAsterisk;
	}

	public void setidAsterisk(String idAsterisk) {
		this.idAsterisk = idAsterisk;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}

	public String getTmoUsuario() {
		return tmoUsuario;
	}

	public void setTmoUsuario(String tmoUsuario) {
		this.tmoUsuario = tmoUsuario;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}



	public Integer getIdLlamadaEntrante() {
		return idLlamadaEntrante;
	}

	public void setIdLlamadaEntrante(Integer idLlamadaEntrante) {
		this.idLlamadaEntrante = idLlamadaEntrante;
	}

	public Integer getIdAgente() {
		return idAgente;
	}
	
	public void setIdAgente(Integer idAgente) {
		this.idAgente = idAgente;
	}
	
	
	}
